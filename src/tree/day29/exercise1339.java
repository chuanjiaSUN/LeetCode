package tree.day29;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 11:17
 */
public class exercise1339 {
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
    int bestSum;
    int sum;
    public int maxProduct(TreeNode root) {
        bestSum = 0;
        sum = travelSum(root);
        dfs(root);
        long ans = (long) bestSum * (sum - bestSum);
        return (int) (ans % (Math.pow(10, 9 ) + 7));
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int cur = dfs(root.left) + dfs(root.right) + root.val;
        if (Math.abs(cur * 2 - sum) < Math.abs(bestSum * 2 - sum))
        {
            bestSum = cur;
        }
        return cur;
    }


    public int travelSum(TreeNode root)
    {
        if (root == null) return 0;
        return root.val + travelSum(root.left) + travelSum(root.right);
    }

}
