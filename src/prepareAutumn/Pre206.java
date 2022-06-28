package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-28 22:24
 */
public class Pre206 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }
}
