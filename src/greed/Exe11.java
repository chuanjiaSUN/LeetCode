package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-27 10:58
 */
public class Exe11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int ans = 0;
        while (l < r)
        {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(area, ans);
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
