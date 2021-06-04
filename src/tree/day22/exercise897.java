package tree.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 10:51
 */
public class exercise897 {
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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size() - 1; i++)
        {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    // 1次遍历更改方向
    private TreeNode preNode;
    public TreeNode increasingBST1(TreeNode root)
    {
        TreeNode dummyNode = new TreeNode(-1);
        preNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        preNode.right = root;
        root.left = null;
        preNode = root;
        inorder(root.right);
    }
}
