package JZ_Offer_linkedList;

import sun.security.util.Length;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-18 21:00
 */
public class offer0202 {
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
    public int kthToLast(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while ( cur != null)
        {
            length++;
            cur = cur.next;

        }
        cur = head;
        for (int i = 1; i < length - k + 1; i++)
        {
            cur = cur.next;
        }
        return cur.val;
    }
}
