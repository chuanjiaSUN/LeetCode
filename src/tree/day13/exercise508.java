package tree.day13;

import tree.day12.exercise501;

import javax.security.auth.Subject;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 11:28
 */
public class exercise508 {
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

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int num : map.keySet())
        {
            if (map.get(num) == max)
            {
                list.add(num);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
