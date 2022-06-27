package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-27 22:18
 */
public class Pre147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head.next;
        ListNode last = head;
        while (cur != null){
            if (last.val <= cur.val){
                last = last.next;
            }else {
                ListNode pre = dummy;
                while (pre.next.val <= cur.val){
                    pre = pre.next;
                }
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = last.next;
        }
        return dummy.next;
    }
}
