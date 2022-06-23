package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-22 22:12
 */
public class Pre94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
