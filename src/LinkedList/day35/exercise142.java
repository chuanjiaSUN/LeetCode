package LinkedList.day35;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-10 13:44
 */
public class exercise142 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
    }
    //哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null)
        {
            if(set.contains(head))
            {
                return head;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
    //快慢指针
    public ListNode detectCycle1(ListNode head)
    {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null)
        {
            slow = slow.next;
            if(fast.next != null)
            {
                fast = fast.next.next;
            }else{
                return null;
            }
            if(fast == slow)
            {
                ListNode cur = head;
                while (cur != slow)
                {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
      return null;
    }
}
