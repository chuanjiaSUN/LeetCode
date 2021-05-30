package LinkedList.day31;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-06 12:04
 */
public class exercise02 {
    class ListNode{
        private int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val)
        {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = null;
        ListNode head = null;
        int rest = 0;
        while( l1 != null || l2 != null)
        {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int cur = ( n1 + n2 + rest ) % 10;
            rest = (n1 + n2 + rest) / 10;
            if(answer == null )
            {
                answer = head = new ListNode(cur);
            }else{
                head.next = new ListNode(cur);
                head = head.next;
            }
            if( l1 != null )
            {
                l1 = l1.next;
            }
            if( l2 != null)
            {
                l2 = l2.next;
            }
        }
        if( rest != 0)
        {
            head.next = new ListNode(rest);
        }
        return answer;
    }
}
