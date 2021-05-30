package LinkedList.day31;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-06 13:17
 */
public class exercise19 {
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
    //小技巧，添加一个亚节点作为头结点的前驱，这样在要删除头结点时不用再做判断
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode tail = null;
        int count = 0;
        tail = head;
        while( tail != null)
        {
            count++;
            tail = tail.next;
        }
        tail = dummy;
        for(int i = 1; i < count - n + 1; i++)
        {
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }

    //法2 栈 (占用内存大)
    public ListNode removeNthFromEnd1(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);//作为头结点的前驱
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null)
        {
            stack.push(cur);
            cur = cur.next;
        }
        for(int i = 0; i < n; i++)
        {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    //双指针  first指针比second超前n个节点
    public ListNode removeNthFromEnd2(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);//哑结点
        ListNode first = head;
        ListNode second = dummy;
        for(int i = 0 ;i < n;i++)
        {
            first = first.next;
        }
        while (first != null)
        {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
