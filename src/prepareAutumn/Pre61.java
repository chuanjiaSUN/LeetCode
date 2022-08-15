package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-15 22:11
 */
public class Pre61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        int pos = k % len;
        for (int i = 0; i < len - pos - 1; i++){
            cur = cur.next;
        }
        ListNode next = null;
        if (cur.next != null){
            next = cur.next;
            cur.next = null;
            ListNode tail = next;
            while (tail.next != null){
                tail = tail.next;
            }
            tail.next = head;
        }
        return next == null ? head : next;
    }
}
