package tree.DFS;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 10:07
 */
public class exe129_Prac {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //dfs
    public int sumNumbers(TreeNode root)
    {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        else
        {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
