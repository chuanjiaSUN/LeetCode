package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-13 21:47
 */
public class Pre19 {
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
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        ListNode pre = dummy;
        for (int i = 0; i < len - n; i++){
            cur = cur.next;
            pre = pre.next;
        }
        ListNode next  = cur.next;
        pre.next = next;
        return dummy.next;

    }
}
