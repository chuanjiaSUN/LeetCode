package tree.DFS;

import tree.day25.exercise998;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 14:09
 */
public class exe998_Prac {
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val)
    {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        if (root.val <= val)
        {
            TreeNode ans = new TreeNode(val, root, null);
            return ans;
        }else
        {
            if (root.right == null)
            {
                root.right = new TreeNode(val);
                return root;
            }else
            {
               root.right = dfs(root.right, val);
            }
        }
        return root;
    }

}
