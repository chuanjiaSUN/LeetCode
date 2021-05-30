package LinkedList.day37;

import LinkedList.day36.exercise148;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-12 13:03
 */
public class exercise160 {
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
    // 超出时间限制
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        ListNode h1 = headA, h2 = headB;
        Map<ListNode, ListNode> map = new HashMap<>();
        map.put(null,h1);
        while (h1.next != null )
        {
            map.put(h1, h1.next);
            h1 = h1.next;
        }
        if(map.containsValue(h2)) return h2;
        while (h2.next != null)
        {
            if(map.containsValue(h2.next)) return h2.next;
            h2 = h2.next;
        }
        return null;
    }

    //法1
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null)
        {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null)
        {
            if (set.contains(cur))return cur;
            cur = cur.next;
        }
        return null;
    }
    //双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2)
        {
            if(h1 != null)
            {
                h1 = h1.next;
            }else{
                h1 = headB;
            }
            if(h2 != null)
            {
                h2 = h2.next;
            }else{
                h2 = headA;
            }
        }
        return h1;
    }

}
