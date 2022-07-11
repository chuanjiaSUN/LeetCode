package prepareAutumn;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-10 22:45
 */
public class Pre437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        int ret = dfsSum(root, targetSum);
        ret += dfsSum(root.left, targetSum);
        ret += dfsSum(root.left, targetSum);
        return ret;
    }

    private int dfsSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        int ret = 0;
        if (targetSum == root.val){
            ret++;
        }
        ret += dfsSum(root.left, targetSum - root.val);
        ret += dfsSum(root.right, targetSum - root.val);
        return ret;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long cur, int targetSum) {
        if (root == null){
            return 0;
        }
        int ret = 0;
        cur += root.val;
        ret = prefix.getOrDefault(cur - targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        ret += dfs(root.left, prefix, cur, targetSum);
        ret += dfs(root.left, prefix, cur, targetSum);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return ret;
    }
}
