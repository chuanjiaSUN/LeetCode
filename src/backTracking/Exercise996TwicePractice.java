package backTracking;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-31 21:30
 */
public class Exercise996TwicePractice {
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graphMap;
    public int numSquareFulPerms(int[] nums)
    {
        count = new HashMap<>(50);
        graphMap = new HashMap<>(50);
        int length = nums.length;

        for (int x : nums)
        {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int x : count.keySet())
        {
            graphMap.put(x, new ArrayList<>());
        }

        for (int x : count.keySet())
        {
            for (int y : count.keySet())
            {
                int r = (int)(Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                {
                    graphMap.get(x).add(y);
                }
            }
        }

        int ans = 0;
        for (int x : count.keySet())
        {
            ans += dfs(x, length - 1);
        }
        return ans;
    }

    private int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0)
        {
            ans = 0;
            for (int y : graphMap.get(x))
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

    /**法2 回溯 + 剪枝*/
    boolean[] visited;
    LinkedList<Integer> track;
    int res = 0;
    int length;
    public int numSquareFulPerms1(int[] nums)
    {
        Arrays.sort(nums);
        length = nums.length;
        track = new LinkedList<>();
        visited = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    private void backTrack(int[] nums) {
        if (track.size() == length)
        {
            res++;
            return;
        }
        for (int i = 0; i < length; i++)
        {
            if (visited[i])
            {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
            {
                continue;
            }
            if (!track.isEmpty() && !isSquare(track.getLast(), nums[i]))
            {
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backTrack(nums);
            track.pollLast();
            visited[i] = false;
        }
    }

    private boolean isSquare(Integer last, int num) {
        int temp = last + num;
        int sqrt = (int)Math.sqrt(temp);
        return sqrt * sqrt == temp;
    }
}
