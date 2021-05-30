package Arrays.day26;

/**
 * @author sunchuanjia
 * @Description 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。

 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 *
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。

 * @create 2021-04-01 11:35
 */
public class exercise717 {
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        int i=0;
        while( i < length - 1)
        {
            i += bits[i] + 1;
        }

        return i==length-1;
    }

    //贪心
    public boolean isOneBitCharacter1(int[] bits)
    {
        int length = bits.length;
        int i = length - 2;
        while(i >= 0 && bits[i] >0)
        {
            i--;
        }
        return (length - i) % 2 == 0;
    }

    public static void main(String[] args) {
        exercise717 e = new exercise717();
        int[] bits = {1,1,1,0};
        boolean oneBitCharacter = e.isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);
    }
}
