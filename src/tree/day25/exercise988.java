package tree.day25;

import tree.DFS.exe987_Prac;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 11:40
 */
public class exercise988 {
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
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append((char) ('a' + root.val));

        if (root.left == null && root.right == null)
        {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();

            if (s.compareTo(ans) < 0)
            {
                ans = s;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }


}
