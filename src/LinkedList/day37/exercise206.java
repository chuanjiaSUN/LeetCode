package LinkedList.day37;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-12 14:50
 */
public class exercise206 {
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
            return "prepareAutumn.ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    //从前往后反转
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode newNode = null;
        while (cur != null)
        {
            ListNode temp = cur.next;
            cur.next = newNode;
            newNode = cur;
            cur = temp;
        }
        return newNode;
    }
    //头插法
    public ListNode reverseList1(ListNode head)
    {
        if(head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur.next != null)
        {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
    //递归
    public ListNode reverseList2(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
