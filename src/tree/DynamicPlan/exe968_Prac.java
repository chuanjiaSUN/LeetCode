package tree.DynamicPlan;

import tree.day23.exercise968;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-05 12:00
 */
public class exe968_Prac {
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
    int result;
    public int minCameraCover(TreeNode root)
    {
        result = 0;
        if (dfs(root) == 0)
        {
            result++;
        }
        return result;
    }

    //采用后序遍历的方式，从下往上，进行贪心，在父节点位置放camera，使得总camera最少
    private int dfs(TreeNode root) {
        if (root == null) return 2;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 2 && right == 2) return 0;

        //
        if (left == 0 || right == 0)
        {
            result++;
            return 1;
        }

        if (left == 1 || right == 1) return 2;

        return -1;

    }
}
