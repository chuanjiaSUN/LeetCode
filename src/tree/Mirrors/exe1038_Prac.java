package tree.Mirrors;

import tree.day26.exercise1038;

import javax.print.attribute.standard.OrientationRequested;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 11:16
 */
public class exe1038_Prac {

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

    int sum = 0;
    public TreeNode bstToGst(TreeNode root)
    {
        if (root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }

    public TreeNode bstToGst1(TreeNode root)
    {
        int sum = 0;
        TreeNode cur = root, predecessor = null;
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
                    predecessor.left = null;
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
