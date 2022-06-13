package LinkedList.day36;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-11 14:38
 */

public class exercise147 {
    static class ListNode{
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
            return "prepareAutumn.ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //从前往后找，进行插入，维护一个LastSort指针表示有序链表的尾指针， cur为待插入元素
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null)
        {
            if(lastSorted.val <= curr.val)
            {
                lastSorted = lastSorted.next;
            }else{
                ListNode prev = dummy;
                while (prev.next.val <= curr.val)
                {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }
    //优化
    public ListNode insertionSortList1(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode cur = dummy.next;
        head = dummy;//记录上一次插入的位置
        while (cur.next != null)
        {
            if( cur.val > cur.next.val)
            {
                ListNode prev = cur.next;
                cur.next = prev.next;
                head = head.val > prev.val ? dummy: head;
                while (head.next.val <= prev.val)
                {
                    head = head.next;
                }
                prev.next = head.next;
                head.next = prev;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
