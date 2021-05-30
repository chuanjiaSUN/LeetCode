package tree.day05;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-18 10:12
 */
public class exercise113 {
    static class TreeNode{
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    //迭代
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<List<Integer>> path = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        path.offer(temp);

        while (!queue.isEmpty())
        {


                TreeNode node = queue.poll();
                List<Integer> combination = path.poll();
                if (node.left == null && node.right == null && isLeaf(combination, targetSum))
                {
                    ans.add(new ArrayList<>(combination));
                    continue;
                }
                if (node.left != null)
                {
                    queue.offer(node.left);
                    combination.add(node.left.val);
                    path.offer(new ArrayList<>(combination));
                    combination.remove(combination.size() - 1);
                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                    combination.add(node.right.val);
                    path.offer(new ArrayList<>(combination));
                }

        }
        return ans;
    }

    private boolean isLeaf(List<Integer> combination, int total) {
        int ans = 0;
        for (int num : combination)
        {
            ans += num;
        }
        return ans == total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(8);
        root.left = treeNode;
        root.right = treeNode1;
        TreeNode treeNode2 = new TreeNode(11);
        treeNode.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(4);
        treeNode1.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(13);
        treeNode1.left = treeNode6;
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode8 = new TreeNode(1);
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;

        exercise113 e = new exercise113();
        List<List<Integer>> lists = e.pathSum(root, 22);
        System.out.println(lists);
    }
    //递归
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, ans, path);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) ans.add(new ArrayList<>(path));
        dfs(root.left, targetSum, ans, path);
        dfs(root.right, targetSum, ans, path);
        path.remove(path.size() - 1);
    }

}
