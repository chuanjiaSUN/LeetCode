package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-12 21:13
 */
public class Pre11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]){
                left++;
            }else{
                right--;
            }

        }
        return maxArea;
    }
}
