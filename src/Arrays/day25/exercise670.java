package Arrays.day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。

 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。

 * @create 2021-03-31 10:32
 */
public class exercise670 {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        char[] charArray = str.toCharArray();

        //记录每个数字出现的最后一次的下标
        int[] last = new int[10];
        for(int i = 0; i < length; i++)
        {
            last[charArray[i] - '0'] = i;
        }

        //从左往右扫描,当前位置右边的最大数字并交换
        for(int i = 0; i < length - 1; i++)
        {
            //找最大,倒着找
            for(int d = 9; d > charArray[i] - '0'; d--)
            {
                if(last[d] > i)
                {
                    swap(charArray, i, last[d]);
                    return Integer.parseInt(new String(charArray));
                }
            }

        }
        return num;
    }

    private void swap(char[] charArray, int i, int i1) {
        char temp = charArray[i];
        charArray[i] = charArray[i1];
        charArray[i1] = temp;
    }

    public int maximumSwap1(int num)
    {
        String str= String.valueOf(num);
        int length = str.length();
        char[] chars = str.toCharArray();
        int maxIndex = length - 1;
        int[] maxArray = new int[length];

        for(int i = maxIndex; i >= 0; i--)
        {
            if(chars[i] > chars[maxIndex])
            {
                maxIndex = i;
            }
            maxArray[i] = maxIndex;
        }

        for(int i = 0; i < length; i++)
        {
            if(chars[maxArray[i]] != chars[i])
            {
                char temp = chars[maxArray[i]];
                chars[maxArray[i]] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public int maximumSwap2(int num)
    {
        char[] chars = Integer.toString(num).toCharArray();
        int length = chars.length;
        int maxIdx = length - 1;
        int[] indexArray = new int[length];

        //从后往前，找出那个数右边最大的值的下标
        for(int i = length - 1; i >= 0; i--)
        {
            if(chars[i] > chars[maxIdx])
            {
                maxIdx = i;
            }
            indexArray[i] = maxIdx;
        }

        //从前往后遍历，把当前值与右边最大的且最后出现的值互换
        for(int i = 0; i < length; i++)
        {
            if( chars[i] != chars[indexArray[i]])
            {
                char temp = chars[i];
                chars[i] = chars[indexArray[i]];
                chars[indexArray[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public int maximumSwap3(int num){
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        int[] indexArray = new int[length];
        int maxIndex = length - 1;
        for(int i = length - 1; i >= 0; i--)
        {
            if( chars[i] > chars[maxIndex])
            {
                maxIndex = i;
            }
            indexArray[i] = chars[maxIndex];//记录当前位置的最大值的坐标
        }

        for(int i = 0; i < length; i++)
        {
            if(chars[i] != chars[indexArray[i]])
            {
                char temp = chars[i];
                chars[i] = chars[indexArray[i]];
                chars[indexArray[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public int maximumSwap4(int num)
    {
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        int[] lastIndex = new int[10];
        for(int i = 0; i < length; i++)
        {
            lastIndex[chars[i] - '0'] = i;
        }
        for(int i = 0; i < length - 1; i++)
        {
            for(int d = 9; d > chars[i]-'0'; d--)
            {
                if(lastIndex[d] > i)
                {
                    char temp = chars[i];
                    chars[i] = chars[lastIndex[d]];
                    chars[lastIndex[d]] = temp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
