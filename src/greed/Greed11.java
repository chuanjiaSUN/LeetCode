package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-09 10:39
 */
public class Greed11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
        {
            return 0;
        }
        int len = height.length;
        int l = 0, r = len - 1;
        int ans = 0;
        while (l < r)
        {
            int area = (r - l) * Math.min(height[l], height[r]);
            ans = Math.max(ans, area);
            if (height[l] < height[r])
            {
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
