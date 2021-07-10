package backTracking;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-10 20:38
 */
public class Exercise1774 {

    private static final int CONTAINS = 20000;
    /**转为0-1背包问题*/
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] bag = new boolean[20000 + 1];
        for (int i : baseCosts)
        {
            bag[i] = true;
        }

        //第一次
        for (int i : toppingCosts)
        {
            for (int j = CONTAINS; j > i; j--)
            {
                bag[j] = bag[j] || bag[j - i];
            }
        }

        //第二次
        for (int i : toppingCosts)
        {
            for (int j = CONTAINS; j > i; j--)
            {
                bag[j] = bag[j] || bag[j - i];
            }
        }

        int ans = baseCosts[0];
        int abs = Integer.MAX_VALUE;
        for (int i = 1; i <= CONTAINS; i++)
        {
            if (bag[i] && Math.abs(i - target) < abs)
            {
                ans = i;
                abs = Math.abs(i - target);
            }
        }
        return ans;
    }

    int ans = Integer.MAX_VALUE;
    /**法2 DFS + 回溯*/
    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target)
    {
        for (int i = 0; i <baseCosts.length; i++)
        {
            int sum = baseCosts[i];
            if (sum == target)
            {
                return target;
            }
            if (Math.abs(baseCosts[i] - target) < Math.abs(ans - target))
            {
                ans = baseCosts[i];
            }
            dfs(toppingCosts, sum, target, 0);
            if (ans == target)
            {
                return target;
            }
        }
        return ans;
    }

    private void dfs(int[] toppingCosts, int sum, int target, int index) {
        if (Math.abs(sum - target) < Math.abs(ans - target))
        {
            ans = sum;
        }else if (Math.abs(sum - target) == Math.abs(ans - target) && sum < ans)
        {
            ans = sum;
        }else if (sum > target)
        {
            return;
        }

        if (sum == target)
        {
            return;
        }
        if (index == toppingCosts.length)
        {
            return;
        }
        dfs(toppingCosts, sum, target, index + 1);
        dfs(toppingCosts, sum + toppingCosts[index], target, index + 1);
        dfs(toppingCosts, sum + 2 * toppingCosts[index], target, index + 1);
    }
}
