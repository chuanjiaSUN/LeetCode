package LinkedList.day34;

import LinkedList.day33.exercise83;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-09 11:23
 */
public class exercise86 {
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

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while ( head != null )
        {
            if( head.val < x)
            {
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
