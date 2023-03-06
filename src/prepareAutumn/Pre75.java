package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-20 23:50
 */
public class Pre75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                swap(nums, i, p1);
                p1++;
            }else if (nums[i] == 0){
                swap(nums, i, p0);
                if (p0 < p1){
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int p0) {
        int temp = nums[i];
        nums[i] = nums[p0];
        nums[p0] = temp;
    }

    /**
     * practice
     * */
    public void sortColors1(int[] nums) {
        int len = nums.length;
        int idx0 = 0;
        int idx2 = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] == 0) {
                swap(nums, i, idx0++);
            }
        }
        for (int i = idx0; i < len; i++){
            if (nums[i] == 1){
                swap(nums, i, idx0++);
            }
        }
    }
    /**
     * practice
     * */
    public void sortColors2(int[] nums) {
        int len = nums.length;
        int index0 = 0;
        int index1 = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] == 1){
                swap(nums, i, index1);
                index1++;
            }else if (nums[i] == 0){
                swap(nums, i, index0);
                if (index0 < index1){
                    swap(nums, i, index1);
                }
                index0++;
                index1++;
            }
        }
    }
}
