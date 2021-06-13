package tree.day31;

import tree.day30.exercise1448;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-13 10:08
 */
public class exercise1457 {
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
    int ans;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int temp) {
        if (root == null) return;
        temp ^= 1 << root.val;
        if (root.left == null && root.right == null)
        {
            if (temp == 0 || (temp & (temp - 1)) == 0)ans++;
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
    }

    public int pseudoPalindromicPaths1 (TreeNode root)
    {
        Map<Integer, Integer> indexMap = new HashMap<>();
        ans = 0;
        dfs1(root, indexMap);
        return ans;
    }

    private void dfs1(TreeNode root, Map<Integer, Integer> indexMap) {
        if (root == null) return;
        indexMap.put(root.val, indexMap.getOrDefault(root.val,0) + 1);
        if (root.left == null && root.right == null)
        {
            if (check(indexMap)) ans++;
        }
        dfs1(root.left, indexMap);
        dfs1(root.right, indexMap);
        indexMap.put(root.val, indexMap.getOrDefault(root.val, 0) - 1);
    }

    private boolean check(Map<Integer, Integer> indexMap) {
        int count = 0;
        for (int i = 1; i <= 9; i++)
        {
            if (indexMap.containsKey(i) && (indexMap.get(i) == 0 || indexMap.get(i) % 2 == 0)) continue;
            if (indexMap.containsKey(i) && indexMap.get(i) % 2 != 0)count++;

            if (count > 1) return false;
        }
        return true;
    }
}
