package Arrays.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合
 *
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @create 2021-03-22 19:57
 */
public class exercise216 {
    //2进制
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int mask=0;mask<(1 << 9);mask++)
        {
            if(check(mask,k,n,res)){
                answer.add(new ArrayList<Integer>(res));
            }
        }
        return answer;
    }

    private boolean check(int mask, int k, int n, List<Integer> res) {
        res.clear();
        for(int i=0;i<9;i++)
        {
            if(((1<<i) & mask) != 0){
                res.add(i+1);
            }
        }
        if(res.size() != k)
        {
            return false;
        }
        int sum = 0;
        for(int num:res)
        {
            sum += num;
        }
        return sum == n;
    }

    //组合枚举
    public List<List<Integer>> combinationSum4(int k, int n){
        List<Integer> res =new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(1,9,k,n,res,ans);
        return ans;
    }

    private void dfs(int cur, int n, int k, int sum, List<Integer> res, List<List<Integer>> ans) {
        if((res.size() + (n-cur+1)) < k || res.size() > k)
        {
            return;
        }
        if(res.size() == k)
        {
            int tempSum = 0;
            for(int num:res)
            {
                tempSum += num;
            }
            if(tempSum == sum)
            {
                ans.add(new ArrayList<>(res));
                return;
            }
        }
        res.add(cur);
        dfs(cur+1,n,k,sum,res,ans);
        res.remove(res.size()-1);
        dfs(cur+1,n,k,sum,res,ans);
    }
    //回溯+剪枝
    public List<List<Integer>> combinationSum41(int k, int n){
        List<Integer> res =new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs1(1,9,k,n,res,ans);
        return ans;
    }

    private void dfs1(int start, int end, int k, int target, List<Integer> res, List<List<Integer>> ans) {
        if(target==0 && res.size()==k)
        {
             ans.add(new ArrayList<>(res));
        }
        for(int i=start;i<=end;i++)
        {
            if(target - i < 0) return;
            res.add(i);
            dfs1(i+1,9,k,target - i,res,ans);
            res.remove(res.size() - 1);
        }
    }

    // 2进制,每一个数字有两种状态，即备选和不被选，所以9个数总计有1<<9个二进制状态，遍历每一个状态，得到该状态下数字总和是否等于n，且个数为k
    public List<List<Integer>> combinationSum32(int k, int n){
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int mask=0;mask<(1<<9);mask++)
        {
            if(checkCombinate(mask,k,n,res,answer))
            {
                answer.add(new ArrayList<>(res));
            }
        }
        return answer;
    }

    private boolean checkCombinate(int mask, int k, int n, List<Integer> res, List<List<Integer>> answer) {
        res.clear();
        for(int i=0;i<9;i++)
        {
            if(((1<<i)&mask) !=0)
            {
                res.add(i+1);
            }
        }
        if(res.size()!=k)return false;
        int sum = 0;
        for(int num:res)
        {
            sum += num;
        }
        return sum == n;
    }

    //-----------------------------------------------------------------------------------
    //对于组合，常使用dfs搜索找出所有的组合
    //回溯 + 剪枝
    public List<List<Integer>> combinationSum33(int k, int n){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> total = new ArrayList<>();
        dfs2(1,9,k,n,path,total);
        return total;
    }

    //DFS回溯搜索
    private void dfs2(int start, int end, int k, int target, List<Integer> path, List<List<Integer>> total) {
        //dfs出口
        if(path.size() == k && target ==0)
        {
            total.add(new ArrayList<>(path));
        }
        if(target < 0) return;//剪枝

        for(int i=start;i<=end;i++)
        {
            path.add(i);
            dfs2(i+1,end,k,target - i,path,total);//dfs
            path.remove(path.size()-1);//回溯
        }

    }

    //组合枚举again
    public List<List<Integer>> combinationSum34(int k, int n){
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        dfs3(1,k,n,combination,answer);
        return answer;
    }

    private void dfs3(int current, int k, int n, List<Integer> combination, List<List<Integer>> answer) {
//        if(combination.size() + (n-current +1)<k || combination.size()>k) return;
        if(current>n)return;
        //剪枝
        if(combination.size()==k)
        {
            int sum = 0;
            for(int num:combination){
                sum += num;
            }
            if(sum == n)
            {
                answer.add(new ArrayList<>(combination));
                return;
            }
        }
        //找出所有组合
        combination.add(current);
        dfs3(current+1,k,n,combination,answer);
        combination.remove(combination.size()-1);
        dfs3(current+1,k,n,combination,answer);
    }

    public static void main(String[] args) {
        exercise216 e = new exercise216();
        int k =3,n=7;
        List<List<Integer>> lists = e.combinationSum33(k, n);
        System.out.println(lists);
    }

}
