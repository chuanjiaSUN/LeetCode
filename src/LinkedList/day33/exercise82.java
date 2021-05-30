package LinkedList.day33;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-08 13:39
 */
public class exercise82 {
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
    //法1 迭代
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(101, head);
        ListNode cur = dummy;//前驱指针
        while (cur.next != null && cur.next.next != null)
        {
            if ( cur.next.val != cur.next.next.val)
            {
                cur = cur.next;
            }else{
                ListNode temp = cur.next;
                int x = temp.val;
                while (temp.next != null && temp.next.val == x)
                {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
        }
        return dummy.next;
    }
    //递归
    public ListNode deleteDuplicates1(ListNode head)
    {
        if( head == null || head.next == null) return head;
        if( head.val != head.next.val)
        {
            head.next = deleteDuplicates1(head.next);
        }else{
            ListNode move = head.next;
            while (move != null && head.val == move.next.val)
            {
                move = move.next;
            }
            return deleteDuplicates1(move.next);
        }
        return head;
    }


    public static void main(String[] args) {

    }
}
