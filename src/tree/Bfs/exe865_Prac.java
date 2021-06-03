package tree.Bfs;

import tree.day21.exercise865;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 14:51
 */
public class exe865_Prac {
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
    // 2 次 DFS
    Map<TreeNode, Integer> depth;
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root)
    {
        depth = new HashMap<>();
        depth.put(null, -1);
        dfs(root, null);
        for (int d : depth.values())
        {
            maxDepth = Math.max(maxDepth, d);
        }
        return answer(root);
    }

    private TreeNode answer(TreeNode root) {
        if (root == null || depth.get(root) == maxDepth) return root;
        TreeNode left = answer(root.left);
        TreeNode right = answer(root.right);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    private void dfs(TreeNode root, TreeNode pre) {
        if (root != null)
        {
            depth.put(root, depth.get(pre) + 1);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }

    // 1次DFS, 在搜索中，确定深度，确定返回的节点
    class  Result
    {
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode subtreeWithAllDeepest1(TreeNode root)
    {
       return dfs1(root).node;
    }

    private Result dfs1(TreeNode root) {
        if (root == null) return new Result(null, 0);
        Result left = dfs1(root.left);
        Result right = dfs1(root.right);
        if (left.depth > right.depth) return new Result(left.node, left.depth + 1);
        if (right.depth > left.depth) return new Result(right.node, right.depth + 1);
        return new Result(root, left.depth + 1);
    }

}
