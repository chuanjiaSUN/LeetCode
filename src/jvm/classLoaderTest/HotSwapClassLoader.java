package jvm.classLoaderTest;

/**
 * @author sunchuanjia
 * @Description 为了多次载入执行类而加入的加载器
 * 开发defineClass方法，只有外部显示调用时才会使用到loadByte方法
 * 被JVM调用时，仍然按照双亲委派使用loadClass方法进行类加载
 * @create 2021-09-26 20:05
 */
public class HotSwapClassLoader extends ClassLoader{
    /**没重写loadClass 与 findClass，因此加载器寻找范围与父类一致*/
    public HotSwapClassLoader()
    {
        //使用其父类加载器，可以使用服务器引用的类库
        super(HotSwapClassLoader.class.getClassLoader());
    }
    /**将提交给执行类的字节码数组byte[]数组转为class对象*/
    public Class loadByte (byte[] classByte){
        return defineClass(null, classByte, 0, classByte.length);
    }
}
