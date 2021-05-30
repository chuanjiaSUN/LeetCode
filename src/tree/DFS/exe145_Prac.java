package tree.DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 10:46
 */
public class exe145_Prac {
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
    //迭代
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //右子节点为空，或者已经遍历过
            if (root.right == null || root.right == prev)
            {
                ans.add(root.val);
                prev = root;
                root = null;// 完成了子树 左 右 根 的遍历，root重置，等stack弹出下一个根节点
            }else
            {
                //否则先遍历右子树，再遍历根节点
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }
}
