package backTracking;

import com.sun.deploy.panel.AdvancedNetworkSettingsDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-05 21:10
 */
public class Exercise1415 {
    List<String> arr;
    StringBuilder sb;
    char[] chars = new char[]{'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        arr = new ArrayList<>();
        sb = new StringBuilder();
        backTrack(n, 0);
        return k > arr.size() ? "" : arr.get(k - 1);
    }

    private void backTrack(int n, int index) {
        if (sb.length() == n && index == n)
        {
            arr.add(sb.toString());
            return;
        }
        for (Character c : chars)
        {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != c || sb.length() == 0)
            {
                sb.append(c);
                backTrack(n, index + 1);
                sb.deleteCharAt(sb.length() -  1);
            }
        }
    }
    /**法2 不用StringBuilder*/
    List<String> list = new ArrayList<>();
    public String getHappyString1(int n, int k)
    {
        char[] nums = {'a', 'b', 'c'};
        dfs(nums, "", n);
        return k > list.size() ? "" : list.get(k - 1);
    }

    private void dfs(char[] nums,String target, int n) {
        if (target.length() == n)
        {
            list.add(target);
            return;
        }
        for (char num : nums) {
            if ("".equals(target) || target.charAt(target.length() - 1) != num) {
                dfs(nums, target + num, n);
            }
        }
    }

}
