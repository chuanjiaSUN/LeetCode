package jvm.javaC;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;
import java.util.TreeSet;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-27 22:14
 */
public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    public void checkName(Element element) {
        nameCheckScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner8<Void, Void>
    {
        /**检查JAVA类*/
        @Override
        public Void visitType(TypeElement e, Void unused) {
            scan(e.getTypeParameters(), unused);
            checkCamelCase(e, true);
            super.visitType(e, unused);
            return null;
        }

        /**检查方法命名合法*/
        @Override
        public Void visitExecutable(ExecutableElement e, Void unused) {
            if (e.getKind() == ElementKind.METHOD)
            {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName()))
                {
                    messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法" + name + "不应当与类名重复,避免与构造函数矛盾", e);
                }
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, unused);
            return null;
        }

        /**检查变量名是否合法*/
        @Override
        public Void visitVariable(VariableElement e, Void unused) {
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e))
            {
                checkAllCaps(e);
            }else{
                checkCamelCase(e, false);
            }
            return null;
        }

        /**大写命名检查*/
        private void checkAllCaps(Element e) {
        }

        /**检查传入的Element是否符合驼峰*/
        private void checkCamelCase(Element e, boolean b) {
        }

        /**检查是否常量*/
        private boolean heuristicallyConstant(VariableElement e) {
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE)
            {
                return true;
            }else if (e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)))
            {
                return true;
            }else{
                return false;
            }
        }
    }

}
