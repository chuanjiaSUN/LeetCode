package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-12 23:54
 */
public class Pre581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxN = Integer.MIN_VALUE;
        int minN = Integer.MAX_VALUE;
        int right = -1;
        int left = -1;
        for (int i = 0; i < n; i++){
            if(maxN > nums[i]){
                right = i;
            }else{
                maxN = nums[i];
            }
            if (minN <  nums[n - i - 1]){
                left = n - i - 1;
            }else{
                minN = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
