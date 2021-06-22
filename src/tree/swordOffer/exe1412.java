package tree.swordOffer;

import String.day03.DFS_exercise17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-20 20:12
 */
public class exe1412 {
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
    List<TreeNode> list;
    int index = 0;
    public TreeNode convertBiNode(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        if (index >= list.size()) return null;
        return  generate(list);
    }

    private TreeNode generate(List<TreeNode> list) {
        while (index < list.size())
        {
            TreeNode cur = list.get(index);
            cur.left = null;
            index++;
            if (index < list.size())
            {
                cur.right = list.get(index);
            }
        }
        return list.get(0);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    //法2
    TreeNode head = new TreeNode(-1);
    TreeNode prev = null;
    public TreeNode convertBiNode1(TreeNode root)
    {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev == null)
        {
            prev = root;
            head.right = root;
        }else
        {
            prev.right = root;
            prev = root;
        }
        root.left = null;
        helper(root.right);
    }
}
