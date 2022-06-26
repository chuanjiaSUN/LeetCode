package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-26 22:53
 */
public class Pre142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (head != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = head;
        while (pre != slow){
            pre = pre.next;
            slow = slow.next;
        }
        return pre;
    }

}
