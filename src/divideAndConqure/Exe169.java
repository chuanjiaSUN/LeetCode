package divideAndConqure;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-01-18 13:58
 */
public class Exe169 {
    public int majorityElement(int[] nums) {
        return majorityEleRec(nums, 0, nums.length - 1);
    }

    private int majorityEleRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = majorityEleRec(nums, low, mid);
        int right = majorityEleRec(nums, mid + 1, high);
        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, low, mid);
        int rightCount = countInRange(nums, right, mid + 1, high);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
    * 法2 摩尔投票法
    * @param nums int[]
    * @return ans int
    * */
    public int majorityElement1(int[] nums){
        int count = 0;
        Integer candidate = null;

        for (int num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }
}
