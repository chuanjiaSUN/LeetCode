package JZ_Offer_linkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-16 12:00
 */
public class offer22 {
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0 , head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0; i < k; i++)
        {
            fast = fast.next;
        }
        ListNode pre = slow;
        while ( fast != null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = null;
        return slow;
    }
}
