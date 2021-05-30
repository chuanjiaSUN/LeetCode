package Arrays.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。*
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：

 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * @create 2021-03-10 10:50
 */
public class exercise39 {

    // 写法1 用递归写深度优先搜索，将在idx位置与在idx+1位置搜索分开。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数，进行搜索
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            System.out.println("combine"+combine);//调试
            dfs(candidates, target - candidates[idx], ans, combine, idx);//继续向下搜索
            combine.remove(combine.size() - 1);//上一行表示在idx位置继续往下搜索找出所有元素，因此为了避免重复在idx位置的元素应删除，以便将下一个位置元素放进来,表示该位置已经搜索过了
        }
    }

    //写法2 将选择此位置与下一位置合并搜索
    public List<List<Integer>> combinationSum1(int[] candidates, int target){
        ArrayList<Integer> combine = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();

        dfs1(candidates,target,combine,result,0);
        return result;
    }

    public void dfs1(int[] candidates,int target,List<Integer> combine,List<List<Integer>> result,int nowPosition)
    {
        if(target<0)
        {
            return;
        }

        if(nowPosition == candidates.length)
        {
            return;//表示搜索至数组终点，该返回了
        }

        if(target == 0)
        {
            result.add(new ArrayList<>(combine));
            return;
        }

        //表示target>=0
        //深度优先搜索,从一个位置begin往下搜索
        for(int begin=nowPosition;begin<candidates.length;begin++)
        {
            combine.add(candidates[begin]);//表示走过该位置
            dfs1(candidates,target-candidates[begin],combine,result,begin);//从该位置继续往下搜索
            combine.remove(combine.size() - 1);//递归结束后需要继续往下搜索，因此换一个位置，将这个位置元素删除，避免重复
        }
    }


    public static void main(String[] args) {
        exercise39 e = new exercise39();
        int[] nums = {2,3,6,7};
        List<List<Integer>> lists = e.combinationSum(nums, 7);
        List<List<Integer>> lists1 = e.combinationSum1(nums, 7);
        System.out.println(lists);
        System.out.println(lists1);
    }


}
