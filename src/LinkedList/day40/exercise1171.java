package LinkedList.day40;

import LinkedList.day39.exercise1019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-15 15:16
 */
public class exercise1171 {
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
    public ListNode removeZeroSumSublists(ListNode head) {
        if( head == null) return head;
        //前缀和
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = dummy;
        int sum = 0;
        while (cur != null)
        {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }
        sum = 0;
        cur = dummy;
        while (cur != null)
        {
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
