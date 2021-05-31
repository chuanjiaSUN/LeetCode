package tree.day18;

import tree.day17.exercise655;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-31 15:10
 */
public class exercise662 {
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
    class AnnotatedNode{
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p)
        {
            node = n;
            depth = d;
            pos = p;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       Queue<AnnotatedNode> queue = new LinkedList<>();
       queue.offer(new AnnotatedNode(root, 0, 0));
       int curDepth = 0, left = 0, ans = 0;
       while (!queue.isEmpty())
       {
           AnnotatedNode node = queue.poll();
           if (node.node != null)
           {
               queue.add(new AnnotatedNode(node.node.left, node.depth + 1, node.pos * 2));
               queue.add(new AnnotatedNode(node.node.right, node.depth + 1, node.pos * 2 + 1));
               if (curDepth != node.depth)
               {
                   curDepth = node.depth;
                   left = node.pos;
               }
               ans = Math.max(ans, node.pos - left + 1);
           }
       }
       return ans;
    }

    //DFS
    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTree1(TreeNode root)
    {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x -> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
