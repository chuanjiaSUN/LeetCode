package Arrays.day02;

/**
 * @author sunchuanjia
 * @Description 11. 盛最多水的容器
 * @create 2021-03-07 15:21
 */
public class exercise11 {
    //双指针往中间移动寻找最大的乘积
    public int maxArea(int[] height) {
        int maxV=0;
        int low=0;
        int length = height.length;
        int high = length-1;
        int max;
        while(low<high){
            max = Math.min(height[high],height[low])*(high-low);
            maxV = Math.max(max,maxV);
            if(height[low]<height[high]){
                low++;
            }else{
                high--;
            }
        }

        return maxV;
    }
}
