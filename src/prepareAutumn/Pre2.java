package prepareAutumn;

import org.junit.Test;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-10 22:02
 */
public class Pre2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }

            ListNode head = null;
            ListNode tail = null;
            int carry = 0;

            while (l1 != null || l2 != null){
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                int addResult = val1 + val2 + carry;
                if (head == null){
                    tail = new ListNode(addResult % 10);
                    head = tail;
                }else{
                    tail.next = new ListNode(addResult % 10);
                    tail = tail.next;
                }
                carry = addResult / 10;
                if (l1 != null){
                    l1 = l1.next;
                }
                if (l2 != null){
                    l2 = l2.next;
                }
            }
            if (carry > 0){
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }
}
