package tree.swordOffer;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-16 12:22
 */
public class exe0403 {
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

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        int level = 0;
        List<ListNode> ans = new ArrayList<>();
        while (!queue.isEmpty())
        {
            int size = queue.size();

            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                dummy.next = new ListNode(node.val);
                dummy = dummy.next;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
            ans.add(cur.next);
        }
       return ans.toArray(new ListNode[0]);
    }
}
