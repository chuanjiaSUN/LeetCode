package num100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 17:33
 */
public class Exe19 {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int len = getLength(head);
        ListNode cur = dummy;
        for (int i = 1 ; i < len - n + 1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;

    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    //栈
    public ListNode removeNthFromEnd1(ListNode head, int n){
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++){
            stack.pop();
        }
        ListNode pre = stack.pop();
        pre.next = pre.next.next;
        return head;
    }
}
