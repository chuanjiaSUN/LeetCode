package tree.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-25 9:20
 */
public class exercise437 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 暴力搜索
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return calPathSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int calPathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int temp = 0;
        targetSum -= root.val;
        if (targetSum == 0) temp++;
        return temp + calPathSum(root.left, targetSum) + calPathSum(root.right, targetSum);
    }

    //前缀和
    public int pathSum1(TreeNode root, int targetSum)
    {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return recursionPath(root, prefixSum, targetSum, 0);
    }

    private int recursionPath(TreeNode node, Map<Integer, Integer> prefixSum, int targetSum, int currSum) {
        if (node == null) return 0;

        int res = 0;
        currSum += node.val;

        res += prefixSum.getOrDefault(currSum - targetSum, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        res += recursionPath(node.left, prefixSum, targetSum, currSum);
        res += recursionPath(node.right, prefixSum, targetSum, currSum);
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);//回溯，去掉当前节点
        return res;
    }


}
