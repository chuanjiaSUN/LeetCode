package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-26 22:50
 */
public class Pre141 {
    public boolean hasCycle(ListNode head) {
            if (head == null){
                return false;
            }
            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != null && fast.next != null){
                if (fast == slow){
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
    }
}
