package tree.Mirrors;

import tree.day01.exercise99;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 16:08
 */
public class exe99_prac {
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
    //Morris算法， 节约维护遍历过的左子树的空间
    public void recoverTree(TreeNode root)
    {
        TreeNode x = null, y = null;// 定义找出错误位置的俩个节点；
        TreeNode prev = null;//前驱指针，判断大小
        TreeNode pre = null;//用来做遍历的前驱，Morris算法的核心

        while (root != null)
        {
            if (root.left != null)
            {
                pre = root.left;
                while (pre.right != null && pre.right != root)
                {
                    pre = pre.right;
                }
                if (pre.right == null)
                {
                    pre.right = root;
                }else
                {
                    if (prev != null && prev.val > root.val)
                    {
                        y = root;
                        if (x == null)
                        {
                            x = prev;
                        }
                    }
                    prev = root;

                    pre.right = null;
                    root = root.right;
                }
            }else
            {
                if (prev != null && prev.val > root.val)
                {
                    y = root;
                    if (x == null)
                    {
                        x = prev;
                    }
                }
                root = root.right;
            }
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = x.val;
    }
}
