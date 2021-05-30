package LinkedList.day41;

import LinkedList.day40.exercise1669;
import jdk.nashorn.internal.ir.LiteralNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-16 11:19
 */
public class exercise1721 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public ListNode swapNodes(ListNode head, int k) {
        if( head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode pre = head;
        int length = 0;
        while (pre != null)
        {
            length++;
            pre = pre.next;
        }
        pre = dummy;
        for(int i = 1; i < k && pre != null; i++)
        {
            pre = pre.next;
        }
        int num1= pre.next.val;
        ListNode node1 = pre.next;
        pre = dummy;
        for(int i = 1; i < length - k + 1; i++)
        {
            pre = pre.next;
        }
        int num2 = pre.next.val;
        ListNode node2 = pre.next;
        node2.val = num1;
        node1.val = num2;
        return dummy.next;
    }
    //快慢指针
    public ListNode swapNodes1(ListNode head, int k)
    {
        if(head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0; i < k; i++)
        {
            fast = fast.next;
        }
        ListNode cur = fast;
        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        int temp = slow.val;
        slow.val = cur.val;
        cur.val = temp;
        return dummy.next;
    }
}
