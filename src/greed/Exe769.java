package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-19 19:10
 */
public class Exe769 {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int max = 0;
        int ans = 0;
        for (int i = 0; i < len; i++)
        {
            max = Math.max(max, arr[i]);
            if(i == max)
            {
                ans++;
            }
        }
        return ans;
    }
}
