package backTracking;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-27 14:04
 */
public class Exercise473 {

    List<Integer> nums;
    int[] sums;
    int possibleSquareSide;
    public boolean makeSquare(int[] matchsticks) {
        sums = new int[4];
        if (matchsticks == null || matchsticks.length == 0)
        {
            return false;
        }
        int len = matchsticks.length;
        int perimeter = 0;
        for (int i = 0; i < len; i++)
        {
            perimeter += matchsticks[i];
        }

        this.possibleSquareSide = perimeter / 4;
        if (possibleSquareSide * 4 != perimeter)
        {
            return false;
        }

        this.nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return dfs(0);
    }

    private boolean dfs(int index) {
        if (index == nums.size())
        {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        int element = nums.get(index);
        for (int i = 0; i < 4; i++)
        {
            if (this.sums[i] + element <= this.possibleSquareSide)
            {
                this.sums[i] += element;
                if (dfs(index + 1))
                {
                    return true;
                }
                this.sums[i] -= element;
            }
        }
        return false;
    }

    /**优化*/

    public boolean makeSquare1(int[] matchsticks)
    {
        int total = 0;
        for (int num : matchsticks)
        {
            total += num;
        }
        if (total == 0 || (total & 3) != 0)
        {
            return false;
        }
        Arrays.sort(matchsticks);
        return backTrack(matchsticks, matchsticks.length - 1, total >> 2, new int[4]);
    }

    private boolean backTrack(int[] nums, int index, int target, int[] size) {
        if (index == -1)
        {
            if (size[0] == size[1] && size[1] == size[2] && size[3] == size[2])
            {
                return true;
            }
            return false;
        }

        for (int i = 0; i < size.length; i++)
        {
            if (size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1]))
            {
                continue;
            }
            size[i] += nums[index];
            if (backTrack(nums, index - 1, target, size))
            {
                return true;
            }
            size[i] -= nums[index];
        }
        return false;
    }

}
