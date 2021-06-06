package tree.day24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-06 14:18
 */
public class exercise993 {
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
    class PosNode
    {
        TreeNode node;
        int k;
        PosNode(TreeNode node, int k)
        {
            this.node = node;
            this.k = k;
        }
    }
    Map<Integer, PosNode> indexMap;
    public boolean isCousins(TreeNode root, int x, int y) {
        indexMap = new HashMap<>();
        dfs(root, null, 0);
        if (indexMap.get(x) != null && indexMap.get(y) != null)
        {
            if (indexMap.get(x).k == indexMap.get(y).k && indexMap.get(x).node.val != indexMap.get(y).node.val)
            {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, TreeNode prev, int depth) {
        if (root != null)
        {
            indexMap.put(root.val, new PosNode(prev, depth));
            dfs(root.left, root, depth +1);
            dfs(root.right, root, depth + 1);
        }
    }
}
