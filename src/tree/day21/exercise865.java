package tree.day21;

import tree.Bfs.exe863_Prac;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 14:20
 */
public class exercise865 {
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
    // 2次 DFS
    Map<TreeNode, Integer> depth;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap<>();
        depth.put(null, -1);
        dfs(root, null);
        maxDepth = -1;
        for (Integer d : depth.values())
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

    private void dfs(TreeNode root, TreeNode parent) {
        if (root != null)
        {
            depth.put(root, depth.get(parent) + 1);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }


    // 1次DFS
    class Result{
        TreeNode node;
        int dist;
        Result(TreeNode node, int d)
        {
            this.node = node;
            this.dist = d;
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
        if (left.dist > right.dist) return new Result(left.node, left.dist + 1);
        if (left.dist < right.dist) return new Result(right.node, right.dist + 1);
        return new Result(root, left.dist + 1);
    }

}
