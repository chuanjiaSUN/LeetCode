package tree.DFS;

import tree.day17.exercise652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-30 11:07
 */
public class exe652_Prac {
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
    Map<String, Integer> trees = new HashMap<>();
    Map<String, Integer> counts = new HashMap<>();
    int t = 1;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root)
    {
        List<TreeNode> ans = new ArrayList<>();
        dfsSerial(root, ans);
        return ans;
    }

    private int dfsSerial(TreeNode root, List<TreeNode> ans) {
        if (root == null) return 0;
        String serial = root.val + "," + dfsSerial(root.left, ans) + "," + dfsSerial(root.right, ans);
        int uId = trees.computeIfAbsent(serial, x -> t++);
        counts.put(serial, counts.getOrDefault(serial, 0) + 1);
        if (counts.get(serial) == 2) ans.add(root);
        return uId;
    }
}
