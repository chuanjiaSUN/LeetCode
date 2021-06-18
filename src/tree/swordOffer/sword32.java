package tree.swordOffer;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-18 13:55
 */
public class sword32 {
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
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if (node != null)
            {
                ans.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
        {
            res[i] = ans.get(i);
        }
        return res;
    }
}
