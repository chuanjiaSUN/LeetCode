package JZ_Offer_linkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-18 21:33
 */
public class offer0205 {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        int rest = 0;
        ListNode res= new ListNode(0);
        ListNode answer = res;
        while ( list1 != null || list2 != null)
        {
            int val1 = list1 == null ? 0 : list1.val;
            int val2 = list2 == null ? 0 : list2.val;
            int add = (val1 + val2 + rest) % 10;
            rest = (val1 + val2 + rest) / 10;
            answer.next = new ListNode(add);
            answer = answer.next;
            if(list1 != null)
            {
                list1 = list1.next;
            }
            if(list2 != null)
            {
                list2 = list2.next;
            }
        }
        if(rest != 0)
        {
            answer.next = new ListNode(rest);
        }
        return res.next;
    }
}
