package LinkedList.day33;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-08 14:41
 */
public class exercise83 {
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        while (cur.next != null )
        {
            ListNode tail = cur.next;
            int x = cur.val;
            if( x == tail.val)
            {
                while ( tail.next != null && x == tail.next.val)
                {
                    tail = tail.next;
                }
                cur.next = tail.next;
            }else{
                cur = tail;
            }
        }
        return head;
    }

    //法2 一次遍历，遍历一次删除一个元素
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        while (cur.next != null )
        {
            if( cur.val == cur.next.val)
            {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    //递归, 跳过相等的元素
    public ListNode deleteDuplicates2(ListNode head)
    {
        if(head == null || head.next == null) return head;
        if(head.val != head.next.val)
        {
            head.next = deleteDuplicates2(head.next);
        }else{
            ListNode move = head.next;
            int x = move.val;
            while (move.next != null && x == move.next.val)
            {
                move = move.next;
            }
            return deleteDuplicates2(move);
        }
        return head;
    }

    //递归每次删除一个重复元素
    public ListNode deleteDuplicates3(ListNode head)
    {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates3(head.next);
        if (head.val != head.next.val) return head;
        else return head.next;
    }


}
