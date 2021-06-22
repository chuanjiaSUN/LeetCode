package backTracking;

import javafx.util.Pair;

import java.time.OffsetDateTime;
import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-22 13:44
 */
public class exercise40 {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans;
    List<Integer> sequence;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        sequence = new ArrayList<>();
        Arrays.sort(candidates);
        for (int num : candidates)
        {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0])
            {
                freq.add(new int[]{num, 1});
            }else
            {
                ++freq.get(freq.size() - 1)[1];
            }
        }
        dfs(target, 0);
        return ans;
    }

    private void dfs(int rest, int pos) {
        if (rest == 0)
        {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) return;

        dfs(rest, pos + 1);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; i++)
        {
            sequence.add(freq.get(pos)[0]);
            dfs(rest - i * freq.get(pos)[0], pos + 1);
        }
        for (int i = 1; i <= most; i++)
        {
            sequence.remove(sequence.size() - 1);
        }
    }

    //法2
    public List<List<Integer>> combinationSum3(int[] candidates, int target)
    {
        int len = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) return ans;

        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs1(candidates, len, 0, target, path, ans);
        return ans;

    }

    private void dfs1(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> ans) {
        if (target == 0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++)
        {
            if (target - candidates[begin] < 0)
            {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) continue;//跳过同一层相同得数

            path.addLast(candidates[i]);
            dfs1(candidates, len, i + 1, target - candidates[i], path, ans);
            path.removeLast();
        }

    }


}
