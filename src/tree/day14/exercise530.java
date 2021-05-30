package tree.day14;

import tree.day13.exercise508;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 19:28
 */
public class exercise530 {
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

    //中序遍历
    int ans = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        InorderDfs(root);
        return ans;
    }

    private void InorderDfs(TreeNode root) {
        if (root == null) return;
        InorderDfs(root.left);
        if (pre == -1)
        {
            pre = root.val;
        }else
        {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        InorderDfs(root.right);
    }


}
