package Arrays.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]*
 * @create 2021-03-16 11:02
 */
public class HuiSu_exercise78 {

    //法1 位运算 加 迭代
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for(int mask=0;mask<(1<<length);mask++)
        {
            res.clear();
            for(int i=0;i<length;i++)
            {
                if((mask & (1<<i))!= 0)
                {
                    res.add(nums[i]);
                }
            }
            list.add(new ArrayList<>(res));
        }
        return  list;
    }

    //法2 递归实现
    public List<List<Integer>> subsets1(int[] nums){
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums,res,ans,0);
        return ans;
    }

    private void dfs(int[] nums, List<Integer> res, List<List<Integer>> ans, int cur) {
        if(cur == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[cur]);//选择当前位置
        dfs(nums,res,ans,cur+1);
        res.remove(res.size()-1);//回溯
        dfs(nums,res,ans,cur+1);//不选择当前位置
    }
}
