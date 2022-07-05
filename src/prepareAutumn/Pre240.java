package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-02 21:22
 */
public class Pre240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0){
            if (matrix[x][y] == target){
                return true;
            }
            if (matrix[x][y] > target){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] nums : matrix){
            int ans = find(nums, target);
            if (ans == target){
            return true;
            }
        }
        return false;
    }

    private int find(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) >> 1;
            if (nums[mid] == target){
                return target;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
