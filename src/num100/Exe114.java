package num100;

import javax.swing.tree.TreeModel;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-24 21:13
 */
public class Exe114 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**法1 前序遍历后展开*/
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        int size = list.size();
        for (int i = 1; i < size; i++){
            TreeNode pre = list.get(i - 1), cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    /**法2 前序遍历同时展开*/
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (prev != null){
                prev.left = null;
                prev.right = cur;
            }
            TreeNode left = cur.left, right = cur.right;
            if (right != null){
                stack.push(right);
            }
            if (left != null){
                stack.push(left);
            }
            prev = cur;
        }
    }

    /**Morris算法*/
    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null){
                TreeNode next = cur.left;
                TreeNode predecessor = next;
                while (predecessor.right != null){
                    predecessor = predecessor.right;
                }
                predecessor.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
