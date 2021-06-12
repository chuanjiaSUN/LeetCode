package tree.day30;

import tree.day29.exercise1372;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-12 11:40
 */
public class exercise1379 {
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
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        ans = null;
        dfs(cloned, target);
        return ans;
    }

    private void dfs(TreeNode cloned, TreeNode target) {
        if (cloned == null) return;
        if (cloned.val == target.val)
        {
            ans = cloned;
            return;
        }
        dfs(cloned.left, target);
        dfs(cloned.right, target);
    }

    //法2
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target)
    {
        if (original == null || cloned == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy1(original.left, cloned.left, target);
        if (left != null) return left;
        return getTargetCopy1(original.right, cloned.right, target);
    }
}
