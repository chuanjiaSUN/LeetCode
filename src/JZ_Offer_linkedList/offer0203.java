package JZ_Offer_linkedList;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-18 21:04
 */
public class offer0203 {
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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
