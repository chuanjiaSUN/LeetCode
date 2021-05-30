package Arrays.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-10 14:43
 */
public class exercise40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> combine = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        String s = Arrays.toString(candidates);
        System.out.println(s);
        dfs(candidates,target,combine,result,0);
        return result;
    }

    public void dfs(int[] candidates,int target,List<Integer> combine,List<List<Integer>> result,int begin)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(combine));
            return;
        }

        for(int position = begin;position<candidates.length;position++)
        {
            if(target - candidates[position] < 0) break; // 大剪枝，按照升序排列后，如果target小于begin位置元素，那么其之后的元素也没必要在搜索

            //小剪支，从candidate数组中第二个元素开始，如果同一层中有相同数值的节点，那position之后的数值搜索出来的结果会与它之前的重复，其是最开始相等的元素搜索结果的子集，因此要跳过
            if(position > begin && candidates[position]==candidates[position-1])
            {
                continue;
            }

            combine.add(candidates[position]);

            //调试语句
            System.out.println("递归之前==>>>"+combine+"位置"+position+",剩余="+(target-candidates[position]));//调试语句

            dfs(candidates,target-candidates[position],combine,result,position+1);//元素不能重复，所以继续向下搜索
            combine.remove(combine.size()-1);

            //调试语句
            System.out.println("递归之后==>>>"+combine+"位置"+position+"剩余="+(target-candidates[position]));
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        exercise40 e = new exercise40();
        List<List<Integer>> res = e.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);


    }
}
