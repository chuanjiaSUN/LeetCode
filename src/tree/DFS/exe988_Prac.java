package tree.DFS;

import tree.day25.exercise988;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 12:03
 */
public class exe988_Prac {
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
        sb.append((char)('a' + root.val));

        if (root.left == null && root.right == null)
        {
            sb.reverse();
            String str = sb.toString();
            sb.reverse();

            if (str.compareTo(ans) < 0)
            {
                ans = str;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
