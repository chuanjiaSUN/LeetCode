package JZ_Offer_linkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-17 11:33
 */
public class offer52 {
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;
        while (list1 != list2)
        {
            list1 = list1 != null ? list1.next : headB;
            list2 = list2 != null ? list2.next : headA;
        }
        return list1;
    }
}
