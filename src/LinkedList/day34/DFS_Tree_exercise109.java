package LinkedList.day34;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2021-04-09 13:55
 */
public class DFS_Tree_exercise109 {
    class ListNode{
        private int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val)
        {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //法1 分治
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, Object right) {
        if(left == right)
        {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMedian(ListNode left, Object right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right)
        {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //法2 分治 + 中序遍历优化
    // 构造二叉搜索树的中序遍历结果就是链表本身 ( 一边比它小，一边比它大)
    ListNode globalHead;
    public TreeNode sortedListToBST1(ListNode head)
    {
        globalHead = head;
        int length = getLength(head);
        return buildTreeOrder(0, length - 1);
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

    //中序遍历建树
    private TreeNode buildTreeOrder(int left, int right) {
        if (left > right) return null;
        int mid = (left + right + 1) >> 1;
        TreeNode root = new TreeNode();
        root.left = buildTreeOrder(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTreeOrder(mid + 1, right);
        return root;
    }
}
