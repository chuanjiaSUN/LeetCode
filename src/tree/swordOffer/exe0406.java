package tree.swordOffer;

import String.day03.DFS_exercise17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-16 13:03
 */

public class exe0406 {
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      list = new ArrayList<>();
      dfs(root, p);
      return list.get(index);
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) return;
        dfs(root.left, p);
        list.add(root);
        if (root == p) index = list.size();
        dfs(root.right, p);
    }

    //法2
    TreeNode prev;
    boolean find;
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p)
    {
        prev = null;
        find = true;
        dfs1(root, p);
        return prev;
    }

    private void dfs1(TreeNode root, TreeNode p) {
        if (root == null) return;
        dfs(root.right, p);
        if (root == p)
        {
            find = false;
            return;
        }
        if (find) prev = root;
        dfs(root.left, p);
    }

}
