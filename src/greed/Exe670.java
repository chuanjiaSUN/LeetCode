package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-16 17:31
 */
public class Exe670 {
    /**暴力*/
    public int maximumSwap1(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] arr = s.toCharArray();
        int max = num;
        for (int i = 0; i < len; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                swap(arr, i, j);
                max = Math.max(max, Integer.parseInt(new String(arr)));
                swap(arr, i, j);
            }
        }
        return max;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**贪心*/
    public int maximumSwap(int num)
    {
        String s = String.valueOf(num);
        int len = s.length();
        char[] arr = s.toCharArray();

        int[] last = new int[10];
        for (int i = 0; i < len; i++)
        {
            last[arr[i] - '0'] = i;
        }

        for (int i = 0; i < len - 1; i++)
        {
            for (int d = 9; d > arr[i] - '0'; d--)
            {
                if (last[d] > i)
                {
                    swap(arr, i, last[d]);
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}
