package tree.day17;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-30 9:58
 */
public class exercise652 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //对DFS结果进行序列化
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<String, Integer> count = new HashMap<>();
        collect(root, ans, count);
        return ans;
    }

    private String collect(TreeNode root, List<TreeNode> ans, Map<String, Integer> count) {
        if (root == null) return "";
        String serial = root.val + "," + collect(root.left, ans, count) + "," + collect(root.right, ans, count);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) ans.add(root);
        return serial;
    }

    //法2
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root)
    {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;
    }

    private int lookup(TreeNode root) {
        if (root == null) return 0;
        String serial = root.val + "," + lookup(root.left) + "," + lookup(root.right);
        int uId = trees.computeIfAbsent(serial, x -> t++);
        count.put(uId, count.getOrDefault(uId, 0) + 1);
        if (count.get(uId) == 2) ans.add(root);
        return uId;
    }
}
