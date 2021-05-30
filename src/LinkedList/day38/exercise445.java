package LinkedList.day38;

import LinkedList.day37.exercise237;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-13 13:40
 */
public class exercise445 {
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
    //用栈存储逆序
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while ( l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while ( l2 != null)
        {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode answer = null;
        int rest = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || rest != 0)
        {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = ( a + b + rest ) % 10;
            rest = ( a + b + rest ) / 10;
            ListNode curNode = new ListNode(cur);
            curNode.next = answer;
            answer = curNode;
        }
        return answer;
    }
}
