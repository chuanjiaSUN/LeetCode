package tree.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 15:32
 */
public class exercise99 {
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
    //法1 显式中序遍历
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swapped = findTwoErrorNum(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null ) return;
        inOrder(root.left,  nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    private int[] findTwoErrorNum(List<Integer> nums) {
        int len = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < len - 1; i++)
        {
            if (nums.get(i + 1) < nums.get(i))
            {
                y = nums.get( i + 1);
                if ( x == -1)
                {
                    x = nums.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null)
        {
            if (root.val == x || root.val == y)
            {
                root.val = root.val == x ? y : x;
                if (--count == 0) return;
            }
           recover(root.left, count, x, y);
           recover(root.right, count, x, y);
        }
    }

    //Morris中序遍历， 不消耗额外空间
    public void recoverTree1(TreeNode root)
    {
        TreeNode x = null, y = null, pred = null, predecessor = null;

        while (root != null)
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
                }else
                {
                    if (pred != null && root.val < pred.val)
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
            }else
            {
                if (pred != null && root.val < pred.val)
                {
                    y = root;
                    if (x == null)
                    {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
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
