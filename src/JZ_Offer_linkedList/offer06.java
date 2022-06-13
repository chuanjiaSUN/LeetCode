package JZ_Offer_linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-16 11:48
 */
public class offer06 {
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
            return "prepareAutumn.ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int length = 0;
        ListNode cur = head;
        while ( cur != null)
        {
            length++;
            list.add(cur.val);
            cur = cur.next;
        }
        int[] ans = new int[length];
        for(int i = 0; i < length; i++)
        {
            ans[i] = list.get(length - i - 1);
        }
        return ans;
    }
    // 不用额外空间
    public int[] reversePrint1(ListNode head)
    {
        if(head == null) return new int[]{};
        int length = 0;
        ListNode cur = head;
        while ( cur != null)
        {
            length++;
            cur = cur.next;
        }
        int[] ans = new int[length];
        cur = head;
        while ( cur != null)
        {
            ans[length - 1] = cur.val;
            cur = cur.next;
            length--;
        }
        return ans;
    }

    //栈
    public int[] reversePrint2(ListNode head)
    {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        int length = 0;
        while (cur != null)
        {
            length++;
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] ans = new int[length];
        int index = 0;
        while ( !stack.isEmpty() && index < length)
        {
            ans[index++] = stack.pop();
        }
        return ans;
    }

}
