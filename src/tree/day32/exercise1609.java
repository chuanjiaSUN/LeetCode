package tree.day32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-14 10:44
 */
public class exercise1609 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int baseNum = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (i == 0) baseNum = node.val;
                if (level % 2 == 0)
                {
                    if (node.val % 2 == 0) return false;
                    if (i >= 1  && baseNum > node.val)
                    {
                        return false;
                    }else baseNum = node.val;
                }else{
                    if (node.val % 2 != 0) return false;
                    if (i >= 1 && baseNum < node.val)
                    {
                        return false;
                    }else baseNum = node.val;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return true;
    }
}
