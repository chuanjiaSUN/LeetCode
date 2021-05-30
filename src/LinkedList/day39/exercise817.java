package LinkedList.day39;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-14 11:07
 */
public class exercise817 {
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
    public int numComponents(ListNode head, int[] G) {
        if(head == null) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i:G) set.add(i);
        int ans = 0;
        int count = 0;
        while (head != null)
        {
            while (head != null && set.contains(head.val))
            {
                count++;
                head = head.next;
            }
            ans += (count != 0 ? 1: 0);
            if(head != null) head = head.next;
            count = 0;
        }
        return ans;
    }
    public int numComponents1(ListNode head, int[] G)
    {
        if(head == null) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i:G) set.add(i);
        int ans = 0;

        while (head != null)
        {
            if(set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) ans++;
            head = head.next;
        }
        return ans;
    }
}
