package tree.day26;

import tree.generateTree.exe1028_Prac;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 10:51
 */
public class exercise1038 {
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
    //DFS反中序遍历
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        return inorder(root);
    }

    private TreeNode inorder(TreeNode root) {
        if (root != null)
        {
            inorder(root.right);
            sum += root.val;
            root.val = sum;
            inorder(root.left);
        }
        return root;
    }

    //Morris
    public TreeNode bstToGst1(TreeNode root)
    {
        int sum = 0;
        TreeNode cur = root;
        TreeNode predecessor = null;
        while (cur != null)
        {
            predecessor = cur.right;
            if (predecessor != null)
            {
                while (predecessor.left != null && predecessor.left != cur)
                {
                    predecessor = predecessor.left;
                }
                if (predecessor.left == null)
                {
                    predecessor.left = cur;
                    cur = cur.right;
                }else
                {
                    predecessor.right = null;
                    sum += cur.val;
                    cur.val = sum;
                    cur = cur.left;
                }
            }else
            {
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
}
