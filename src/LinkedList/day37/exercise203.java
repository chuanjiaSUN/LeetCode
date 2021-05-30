package LinkedList.day37;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-12 14:35
 */
public class exercise203 {
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        while (pre.next != null)
        {
            if(pre.next.val == val)
            {
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
