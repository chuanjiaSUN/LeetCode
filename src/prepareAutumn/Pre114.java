package prepareAutumn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-24 21:12
 */
public class Pre114 {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        root = list.get(0);
        for (int i = 1; i < list.size(); i++){
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null){
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    /**栈迭代*/
    public void flatten1(TreeNode root) {
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

        for (int i = 1; i < list.size(); i++){
            TreeNode pre = list.get(i - 1);
            pre.right = list.get(i);
            pre.left = null;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null){
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
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (right != null){
                stack.push(right);
            }
            if (left != null){
                stack.push(left);
            }
            prev = cur;
        }
    }

    public void flatten3(TreeNode root) {
        TreeNode cur = root;

        while (cur != null){
            if (cur.left != null){
                TreeNode next = cur.left;
                TreeNode predessor = next;
                while (predessor.right != null){
                    predessor = predessor.right;
                }
                predessor.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
    /**
     * practice
     * */
    public void flatten4(TreeNode root) {
        if(root == null){
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int size = list.size();
        for (int i = 0; i < size - 1; i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(size - 1).left = null;

    }

    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null){
            return;
        }
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    public void flatten5(TreeNode root){
        if (root == null){
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
             TreeNode left = cur.left;
             TreeNode right = cur.right;
             if (right != null){
                 stack.push(right);
             }
             if (left != null){
                 stack.push(left);
             }
             prev = cur;
        }
    }
    public void flatten6(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (prev != null){
                prev.right = cur;
                prev.left = null;
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
            prev = cur;
        }
    }




}
