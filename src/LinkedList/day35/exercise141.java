package LinkedList.day35;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-10 13:19
 */
public class exercise141 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
    }

    //法1 快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                return true;
            }
        }
        return false;
    }

    //法2 哈希表
    public boolean hasCycle1(ListNode head)
    {
        Set<ListNode> set = new HashSet<>();
        while (head != null)
        {
            if(!set.contains(head))
            {
                set.add(head);
            }else{
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //法3 快慢指针
    public boolean hasCycle2(ListNode head)
    {
        if( head == null || head.next == null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast)
        {
            if(fast == null || fast.next == null)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
