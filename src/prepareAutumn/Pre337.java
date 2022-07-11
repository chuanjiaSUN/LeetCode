package prepareAutumn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-06 23:27
 */
public class Pre337 {
    Map<TreeNode, Integer> father = new HashMap<>();
    Map<TreeNode, Integer> ground = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(father.getOrDefault(root, 0), ground.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        father.put(root, root.val + ground.getOrDefault(root.left, 0) + ground.getOrDefault(root.right, 0));
        ground.put(root, Math.max(father.getOrDefault(root.left, 0), ground.getOrDefault(root.left, 0)) + Math.max(father.getOrDefault(root.right, 0), ground.getOrDefault(root.right, 0)));
    }


}
