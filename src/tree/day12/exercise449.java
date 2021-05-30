package tree.day12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-25 9:44
 */
public class exercise449 {
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
    public String serialize(TreeNode root) {
        return dserialize(root, "");
    }

    private String dserialize(TreeNode root, String str) {
        if (root == null)
        {
            return str + "None,";
        }
        str += root.val + ",";
        str = dserialize(root.left, str);
        str = dserialize(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return rdeserialize(list);
    }

    private TreeNode rdeserialize(List<String> list) {
        if ("None".equals(list.get(0)))
        {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }
}
