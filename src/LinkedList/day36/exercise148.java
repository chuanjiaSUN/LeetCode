package LinkedList.day36;

import java.util.Timer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-11 15:37
 */
public class exercise148 {
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
    //插排
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode lastNode = head;
        ListNode curr = head.next;
        head = dummy;
        while (curr != null)
        {
            if(lastNode.val <= curr.val)
            {
                lastNode = lastNode.next;
            }else{
                head = head.val > curr.val ? dummy : head;
                while (head.next.val <= curr.val)
                {
                    head = head.next;
                }
                lastNode.next = curr.next;
                curr.next = head.next;
                head.next = curr;

            }
            curr = lastNode.next;
        }
        return dummy.next;
    }
    // 自顶向下，归并排序  找到链表的中点，拆分为2个子表,排序后合并
    //归并采用了分治的思想
    public ListNode sortList1(ListNode head)
    {
        return sortList1(head, null);
    }

    //当链表只剩一个或空时，退出递归
    private ListNode sortList1(ListNode head, ListNode tail) {
        if(head == null) return head;

        if(head.next == tail)
        {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail)
        {
            fast = fast.next;
            slow = slow.next;
            if(fast != tail) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList1(head, mid);
        ListNode list2 = sortList1(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy, temp1 =head1, temp2 = head2;
        while (temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
              temp.next = temp1;
              temp1 = temp1.next;
            }else{
               temp.next = temp2;
               temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null)
        {
            temp.next = temp1;
        }else if(temp2 != null){
            temp.next = temp2;
        }
        return dummy.next;
    }

    // 自底向上归并排序  空间复杂度为O(1)  先求长度，再拆成2个子表合并
    public ListNode sortList2(ListNode head)
    {
        if(head == null) return head;
        ListNode node = head;
        int length = getLength(node);
        ListNode dummy = new ListNode(0, head);
        for(int subLength = 1; subLength < length; subLength <<= 1)
        {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null)
            {
                ListNode head1 = curr;
                for(int i = 1; i < subLength && curr.next != null; i++)
                {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;//2个子表
                curr = head2;
                for(int i = 1; i < subLength && curr != null &&curr.next != null; i++)
                {
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null)
                {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge1(head1, head2);
                prev.next = merged;
                while (prev.next != null)
                {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummy.next;
    }

    private ListNode merge1(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
                pre.next = temp1;
                temp1 = temp1.next;
            }else{
                pre.next = temp2;
                temp2 = temp2.next;
            }
            pre = pre.next;
        }
        if( temp1 != null)
        {
            pre.next = temp1;
        }else if(temp2 != null)
        {
            pre.next = temp2;
        }
        return dummy.next;
    }

    private int getLength(ListNode node) {
        int ret = 0;
        while (node != null)
        {
            ret++;
            node = node.next;
        }
        return ret;
    }

}
