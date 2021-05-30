package tree.day11;

import javax.xml.soap.Node;
import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-24 13:49
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
    // 动态规划
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
       dfs(root);
       return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root,
                Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                        +
                Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0))
        );
    }

    //空间优化
    public int rob1(TreeNode root)
    {
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private int[] dfs1(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int[] left = dfs1(root.left);
        int[] right = dfs1(root.right);
        int selected = root.val + left[1] + right[1];
        int noSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, noSelected};
    }


}
