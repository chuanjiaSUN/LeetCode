package tree.swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-19 13:12
 */
public class sword34 {
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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, target, path);
        return ans;
    }

    private void dfs(TreeNode root, int target, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null)
        {
            if (check(path, target))
            {
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);
        path.remove(path.size() - 1);
    }

    private boolean check(List<Integer> path, int target) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++)
        {
            sum += path.get(i);
        }
        return sum == target;
    }
}
