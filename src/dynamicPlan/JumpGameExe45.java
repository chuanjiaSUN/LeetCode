package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-01 11:14
 */
public class JumpGameExe45 {
    int ans = 0;
    /**在可跳范围内找最大跳跃范围, 达到边界step+1 */
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < length - 1; i++)
        {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (i == end)
            {
                end = maxPosition;
                ans++;
            }
        }
        return ans;
    }
    /**法2 反向贪心*/
    public int jump2(int[] nums){
        int position = nums.length - 1;
        while (position > 0)
        {
            for (int i = 0; i < position; i++)
            {
                if (i + nums[i] >= position)
                {
                    position = i;
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
