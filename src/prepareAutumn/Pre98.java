package prepareAutumn;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-22 22:23
 */
public class Pre98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int minValue, int maxValue) {
        if (root == null){
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }

    /**
     * 中序遍历
     * */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
