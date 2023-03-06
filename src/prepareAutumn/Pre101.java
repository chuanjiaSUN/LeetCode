package prepareAutumn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-23 21:40
 */
public class Pre101 {
    public boolean isSymmetric(TreeNode root) {
        return inorder(root, root);
    }

    private boolean inorder(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.val == right.val && inorder(left.left, right.right) && inorder(left.right, right.left);
    }

    private boolean check(TreeNode left, TreeNode right){
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(left);
        stack.offer(right);

        while (!stack.isEmpty()){
            left = stack.poll();
            right = stack.poll();
            if (left == null && right == null){
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)){
                return false;
            }
            stack.offer(left.right);
            stack.offer(right.left);
            stack.offer(left.left);
            stack.offer(right.right);
        }
        return true;
    }
    /**
     * practice
     * */
    public boolean isSymmetric1(TreeNode root) {
        return stackCheck(root, root);
    }

    private boolean stackCheck(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);

        while (!queue.isEmpty()){
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            queue.offer(left.right);
            queue.offer(right.left);
            queue.offer(left.left);
            queue.offer(right.right);
        }
        return true;
    }

    private boolean dfsCheck(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return dfsCheck(left.left, right.right) && dfsCheck(left.right, right.left);
    }
}
