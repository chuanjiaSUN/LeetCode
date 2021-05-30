package tree.day17;

import tree.day16.exercise623;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-30 9:45
 */
public class exercise637 {
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
    //BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            double levelSum = 0;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(levelSum / size);
        }
        return ans;
    }
    //DFS
    public List<Double> averageOfLevels1(TreeNode root)
    {
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < sums.size(); i++)
        {
            ans.add(sums.get(i) / counts.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> counts, List<Double> sums) {
        if (root == null) return;
        if (depth < sums.size())
        {
            sums.set(depth, sums.get(depth) + root.val);
            counts.set(depth, counts.get(depth) + 1);
        }else
        {
            sums.add(root.val * 1.0);
            counts.add(1);
        }
        dfs(root.left, depth + 1, counts, sums);
        dfs(root.right, depth + 1, counts, sums);
    }


}
