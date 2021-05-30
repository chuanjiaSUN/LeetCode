package LinkedList.day35;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.util.List;
import java.util.Random;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-10 15:01
 */
public class exercise109_practice2 {
    class ListNode{
        int val;
        ListNode next;
        ListNode()
        {}
        ListNode(int val)
        {this.val = val;}
        ListNode(int val,ListNode next)
        {this.val = val; this.next = next;}
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){this.val = val;this.left = left;this.right = right;}
    }
    // 分治 从中间往两边分别建树
    public TreeNode sortedListToBST(ListNode head)
    {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, Object right) {
        if(left == right) return null;
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMedian(ListNode left, Object right) {
        if(left == right) return left;
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //分治 + 中序遍历优化
    ListNode gloablNode;
    public TreeNode sortedListToBST1(ListNode head)
    {
        if(head == null) return null;
        int length = getLength(head);
        gloablNode = head;
        return buildMidOrderTree(0 ,length - 1);
    }

    private TreeNode buildMidOrderTree(int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode();
        int mid = ( 1 + left + right) >> 1;
        root.left = buildMidOrderTree(left, mid - 1);
        root.val = gloablNode.val;
        gloablNode = gloablNode.next;
        root.right = buildMidOrderTree(mid + 1, right);
        return root;
    }

    private int getLength(ListNode head) {
        int ret = 0;
        while (head != null)
        {
            ret++;
            head = head.next;
        }
        return ret;
    }

}
