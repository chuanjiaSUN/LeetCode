package tree.day13;

import sun.reflect.generics.tree.Tree;

import javax.management.MXBean;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 12:08
 */
public class exercise515 {
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (node.val > maxNum) maxNum = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(maxNum);
        }
        return ans;
    }

    //DFS
    List<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues1(TreeNode root)
    {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int currDepth) {
        if (root == null) return;
        if (ans.size() == currDepth)
        {
            ans.add(currDepth, root.val);
        }
        int max = Math.max(ans.get(currDepth), root.val);
        ans.set(currDepth, max);
        dfs(root.left, currDepth + 1);
        dfs(root.right, currDepth + 1);
    }
}
