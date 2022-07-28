package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-28 23:30
 */
public class Pre24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        if (head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null && next != null){
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = pre.next.next;
            if (pre.next == null){
                break;
            }else{
                cur = pre.next;
            }
            if (pre.next.next == null){
                break;
            }else{
                next = pre.next.next;
            }
        }
        return dummy.next;
    }
}
