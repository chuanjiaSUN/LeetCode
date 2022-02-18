package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 15:42
 */
public class Exe11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r){
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            if (height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
