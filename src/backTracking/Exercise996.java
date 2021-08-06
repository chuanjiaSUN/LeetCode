package backTracking;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-17 16:17
 */
public class Exercise996 {
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        count = new HashMap<>(50);
        graph = new HashMap<>(50);

        for (int num : nums)
        {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet())
        {
            graph.put(num, new ArrayList<>());
        }

        for (int x : count.keySet())
        {
            for (int y : count.keySet())
            {
                int r = (int)(Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                {
                    graph.get(x).add(y);
                }
            }
        }

        int ans = 0;
        for (int x : count.keySet())
        {
            ans += dfs(x, len - 1);
        }
        return ans;
    }

    private int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0)
        {
            ans = 0;
            for (int y : graph.get(x))
            {
                if (count.get(y) != 0)
                {
                    ans += dfs(y, todo - 1);
                }
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }


}
