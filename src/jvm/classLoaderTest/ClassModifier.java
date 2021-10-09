package jvm.classLoaderTest;

/**
 * @author sunchuanjia
 * @Description 修改class文件中常量池, 将服务器打印使用的标准输出替换为自定义的print类
 * @create 2021-09-26 20:11
 */
public class ClassModifier {

    /**常量池起始偏移*/
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**utf8_info常量的flag标志*/
    private static final int CONSTANT_Utf8_info = 1;

    /**常量池11种常量所占长度*/
    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte)
    {
        this.classByte = classByte;
    }


    /**
     * 修改常量池CONSTANT_UTF8_INFO内容，传给hotSwap的加载器进行类加载
     * @param oldStr 修改前
     * @param newStr 修改后
     * @return 修改结果
     * */
    public byte[] modifyUTF8Constant(String oldStr, String newStr)
    {
        int cpc = getConstantPoolCount();
        int offSet = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < cpc; i++)
        {
            int tag = ByteUtils.byte2Int(classByte, offSet, u1);
            if (tag == CONSTANT_Utf8_info)
            {
                int len = ByteUtils.byte2Int(classByte, offSet + u1, u2);
                offSet += (u1 + u2);
                String str = ByteUtils.bytes2String(classByte, offSet, len);
                if (str.equalsIgnoreCase(oldStr))
                {
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strlen = ByteUtils.int2Bytes(newStr.length(), u2);
                    classByte = ByteUtils.bytesReplace(classByte, offSet - u2, u2, strlen);
                    classByte = ByteUtils.bytesReplace(classByte, offSet, len, strBytes);
                    return classByte;
                }else{
                    offSet += len;
                }
            }else{
                offSet += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }

    private int getConstantPoolCount() {
        return ByteUtils.byte2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }
}
