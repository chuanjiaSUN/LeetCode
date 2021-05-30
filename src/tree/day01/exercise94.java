package tree.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 10:44
 */
public class exercise94 {
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
    //递归调用
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
    //迭代调用
    public List<Integer> inorderTraversal1(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
    //Morris中序遍历
    public List<Integer> inorderTraversal2(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        TreeNode pre= null;
        while (root != null)
        {
            //如果左节点不为空，就将当前节点连带右子树全部挂在左节点的最后子树下面
            if (root.left != null)
            {
                pre = root.left;
                while (pre.right != null)
                {
                    pre = pre.right;
                }
                pre.right = root;//挂右边
                //将root指向root的left
                TreeNode temp = root;
                root =root.left;
                temp.left = null;
                //左子树为空，则打印这个节点，并向右遍历
            }else
            {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    //其实整个过程我们就多做一步：假设当前遍历到的节点为 xx，
    // 将 xx 的左子树中最右边的节点的右孩子指向 xx，
    // 这样在左子树遍历完成后我们通过这个指向走回了 xx，
    // 且能通过这个指向知晓我们已经遍历完成了左子树，
    // 而不用再通过栈来维护，省去了栈的空间复杂度。



    //Morris
    public List<Integer> inorderTraversal3(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;

        while (root != null)
        {
            if (root.left != null)
            {
                pre = root.left;
                while (pre.right != null && pre.right != root)
                {
                    pre = pre.right;
                }
                //让pre右指针指向root,继续遍历左子树
                if (pre.right == null)
                {
                    pre.right = root;
                    root = root.left;
                }else//说明左子树已经访问完， 断开连接
                {
                    res.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            }else//说明没有左孩子，则直接访问右孩子
            {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
