package tree.swordOffer;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-20 11:11
 */
public class exe0412 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
       preOrder(root, sum);
       return ans;
    }

    private void preOrder(TreeNode root, int sum) {
        if (root == null) return;
        dfs(root, sum);
        preOrder(root.left, sum);
        preOrder(root.right, sum);
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        if (sum - root.val == 0) ans++;
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }

    //法2
    public int pathSum1(TreeNode root, int sum)
    {
        if (root == null) return 0;
        return pathSum1(root.left, sum) + pathSum1(root.right, sum) + helper(root, sum);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = sum == root.val ? 1 : 0;
        sum -= root.val;
        return helper(root.left, sum) + helper(root.right, sum) + res;
    }


}
