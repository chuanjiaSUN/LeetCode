package LinkedList.day32;

/**
 * @author sunchuanjia
 * @Description
 *                      给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *                      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * @create 2021-04-07 10:51
 */
public class dfs_exercise24 {
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
    // 迭代
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null)
        {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }
    //递归
    public ListNode swapPairs1(ListNode head)
    {
        if( head == null || head.next == null)
        {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
