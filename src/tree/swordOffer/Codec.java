package tree.swordOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-18 11:59
 */
public class Codec {
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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder res = new StringBuilder("[");

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node != null)
            {
                res.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() -1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null"))
            {
                node.left = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(node.left);
            }
            i++;
            if (!vals[i].equals("null"))
            {
                node.right = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    //DFS
    public String serialize1(TreeNode root)
    {
        return rserialize1(root, "");
    }

    private String rserialize1(TreeNode root, String str) {
        if (root == null) str += "None,";
        else{
            str += String.valueOf(root.val) + ",";
            str = rserialize1(root.left, str);
            str = rserialize1(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize1(String data)
    {
        String[] dataArray = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize1(list);
    }

    private TreeNode rdeserialize1(List<String> list) {
        if (list.get(0).equals("None")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize1(list);
        root.right = rdeserialize1(list);
        return root;
    }
}
