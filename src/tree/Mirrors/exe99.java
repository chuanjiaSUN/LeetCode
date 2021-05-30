package tree.Mirrors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 16:35
 */
public class exe99 {
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

    public void recoverTree(TreeNode root)
    {
        TreeNode x = null, y = null, pred = null, predecessor = null;

        while ( root != null)
        {
            if (root.left != null)
            {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root)
                {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null)
                {
                    predecessor.right = root;
                    root = root.left;
                }else{
                    if (pred != null && pred.val > root.val)
                    {
                        y = root;
                        if (x == null)
                        {
                            x = pred;
                        }
                    }

                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            }else{
                if (pred != null && pred.val > root.val)
                {
                    y = root;
                    if (x == null) x = pred;
                }
                root =root.right;
            }
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

}
