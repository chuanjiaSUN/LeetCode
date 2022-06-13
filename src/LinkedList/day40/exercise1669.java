package LinkedList.day40;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-15 16:13
 */
public class exercise1669 {
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode pre = dummy;//前驱指针
        for(int i = 0; i < a ; i++)
        {
            pre = pre.next;
        }
        ListNode tail = pre;
        for(int i = a-1; i < b; i++)
        {
            tail = tail.next;
        }
        ListNode next = tail.next;
        tail.next = null;
        tail = list2;
        while (tail.next != null)
        {
            tail = tail.next;
        }
        tail.next = next;
        pre.next = list2;
        return dummy.next;
    }
}
