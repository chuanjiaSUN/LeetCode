package tree.day16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 13:58
 */
public class exercise623 {
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return new TreeNode(val);
        if (depth == 1)
        {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length = 1;

        while (length < depth - 1)
        {
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            length++;
        }

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }

    //DFS
    public TreeNode addOneRow1(TreeNode root, int val, int depth)
    {
        if (depth == 1)
        {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfsInsert(root, val, 1, depth);
        return root;
    }

    private void dfsInsert(TreeNode root, int val, int curDepth, int depth) {
        if (root == null) return;
        if (curDepth == depth - 1)
        {
            TreeNode temp = root.left;
            root.left = new TreeNode(val);
            root.left.left = temp;
            temp = root.right;
            root.right = new TreeNode(val);
            root.right.right = temp;
        }else
        {
            dfsInsert(root.left, val, curDepth + 1, depth);
            dfsInsert(root.right, val, curDepth + 1, depth);
        }
    }
}
