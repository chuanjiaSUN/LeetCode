package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-05 14:52
 */
public class Pre92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode pre = null;
        for (int i = 0; i < left - 1; i++){
            if (i == left - 2){
                pre = cur;
            }
            cur = cur.next;
        }
        ListNode newHead = cur;
        cur = head;
        for (int i = 0; i < right - 1; i++){
            cur = cur.next;

        }
        ListNode newTail = cur;
        ListNode next = newTail.next;
        ListNode[] reverse = reverse(newHead, newTail);
        if (pre != null){
            pre.next = reverse[0];
        }else{
            head = reverse[0];
        }
        reverse[1].next = next;
        return head;
    }

    private ListNode[] reverse(ListNode newHead, ListNode newTail) {
        ListNode pre = null;
        ListNode head = newHead;
        ListNode tail = newTail;
        while (head != tail){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return new ListNode[]{newTail, newHead};
    }
}
