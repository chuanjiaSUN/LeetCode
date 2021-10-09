package jvm.classLoaderTest;

import java.lang.reflect.Method;

/**
 * @author sunchuanjia
 * @Description 调用支持类，完成执行类加载工作
 * @create 2021-09-26 20:44
 */
public class JavaClassExecuter {

    public static String execute(byte[] classByte)
    {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "jvm/classLoaderTest/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
