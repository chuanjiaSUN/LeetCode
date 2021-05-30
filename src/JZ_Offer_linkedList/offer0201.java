package JZ_Offer_linkedList;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-17 11:56
 */
public class offer0201 {
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
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head== null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pre = head;
        while ( pre.next != null)
        {
            ListNode cur = pre.next;
            if (set.add(cur.val))
            {
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
        }
        pre.next = null;

        return head;
    }

    //法2
    public ListNode removeDuplicateNodes1(ListNode head)
    {
        ListNode ob = head;
        while ( ob != null)
        {
            ListNode oc = ob;
            while (oc.next != null)
            {
                if (oc.next.val == ob.val)
                {
                    oc.next = oc.next.next;
                }else{
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }
}
