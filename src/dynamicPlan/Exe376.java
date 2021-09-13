package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 10:22
 */
public class Exe376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null)
        {
            return 0;
        }
        if (nums.length == 1)
        {
            return 1;
        }
        if (nums.length == 2 && nums[0] != nums[1])
        {
            return 2;
        }
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++)
        {
            if (nums[i] > nums[i - 1])
            {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            }else if (nums[i] < nums[i - 1])
            {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            }else{
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }
}
