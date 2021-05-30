package tree.day13;

import javafx.scene.transform.Rotate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 11:44
 */
public class exercise513 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //BFS
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode ans = null;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (i == 0) ans = node;
                if (node.left != null)
                {
                    queue.offer(node.left);
                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                }
            }
        }
        return ans.val;
    }
    //DFS
    int maxDepth = -1;
    int ans = 0;
    public int findBottomLeftValue1(TreeNode root)
    {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int curDepth) {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            if (curDepth > maxDepth)//保证只有第一个会进来
            {
                maxDepth = curDepth;
                ans = root.val;
            }
        }
        if (root.left != null) dfs(root.left, curDepth + 1);
        if (root.right != null) dfs(root.right, curDepth + 1);
    }
}
