package tree.day18;

import java.time.chrono.MinguoChronology;
import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-31 16:08
 */
public class exercise671 {
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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        if (set.size() < 2) return -1;
        set.remove(root.val);
        List<Integer> list = new ArrayList<>(set);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++)
        {
            if (ans > list.get(i)) ans = list.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
    //法2 空间优化
    public int findSecondMinimumValue1(TreeNode root)
    {
        if (root == null) return -1;
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
