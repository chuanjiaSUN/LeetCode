package LinkedList.day40;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-15 15:39
 */
public class exercise1290 {
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
    //法1
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        int pos = 0;
        double ans = 0;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null)
        {
            pos++;
            list.add(cur.val);
            cur = cur.next;
        }
        for(int i = 0; i < list.size(); i++)
        {
            ans += list.get(i) * Math.pow(2, pos-1);
            pos--;
        }
        return (int)ans;
    }
    // 法2
    public int getDecimalValue1(ListNode head)
    {
            if(head == null) return 0;
            ListNode cur = head;
            int ans = 0;
            while (cur != null)
            {
                ans = ans * 2 + cur.val;
                cur = cur.next;
            }
            return ans;
    }
}
