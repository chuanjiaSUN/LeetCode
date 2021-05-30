package tree.day14;

import String.day03.DFS_exercise17;
import tree.day13.exercise508;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 19:41
 */
public class exercise538 {
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
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        inorder(cur, list);
        SuffixSum(list);
        cur = root;
        inorderSet(cur, list);
        return root;
    }

    private void inorderSet(TreeNode cur, List<Integer> list) {
        if (cur == null) return;
        if (cur.left != null)inorderSet(cur.left, list);
        cur.val = list.get(0);
        list.remove(0);
        if (cur.right != null)inorderSet(cur.right, list);
    }

    private void SuffixSum(List<Integer> list) {
        int last = 0;
        for (int i = list.size() - 1; i >= 0; i--)
        {
            int cur = list.get(i);
            list.set(i, cur + last);
            last = cur + last;
        }
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null)inorder(root.left, list);
        list.add(root.val);
        if (root.right != null)inorder(root.right, list);
    }

    //反序中序遍历

    int sum = 0;
    public TreeNode convertBST1(TreeNode root)
    {
        if (root != null )
        {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    //Morris算法
    public TreeNode convertBST2(TreeNode root)
    {
        int sum = 0;
        TreeNode predecessor = null;
        TreeNode cur = root;
        while (root != null)
        {
            if (root.right == null)
            {
                sum += root.val;
                root.val = sum;
                root = root.left;
            }else
            {
                predecessor = root.right;
                while (predecessor.left != null && predecessor.left != root)
                {
                    predecessor = predecessor.left;
                }
                if (predecessor.left == null)
                {
                    predecessor.left = root;
                    root = root.right;
                }else
                {
                    predecessor.left = null;
                    sum += root.val;
                    root.val = sum;
                    root = root.left;
                }
            }
        }
        return cur;
    }
}
