package tree.dynamicPlanning;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-24 14:26
 */
public class exercise337 {
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
    public int rob(TreeNode root)
    {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int selected = root.val + left[1] + right[1];
        int noSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, noSelected};
    }

    Map<TreeNode, Integer> selected = new HashMap<>();
    Map<TreeNode, Integer> noSelected = new HashMap<>();
    public int rob1(TreeNode root)
    {
        dfs1(root);
        return Math.max(selected.get(root), noSelected.get(root));
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        dfs1(root.left);
        dfs1(root.right);
        selected.put(root, root.val + noSelected.getOrDefault(root.left, 0) + noSelected.getOrDefault(root.right, 0));
        noSelected.put(root, Math.max(selected.getOrDefault(root.left, 0), noSelected.getOrDefault(root.left, 0)) +
                Math.max(selected.getOrDefault(root.right, 0), noSelected.getOrDefault(root.right, 0)));
    }
}
