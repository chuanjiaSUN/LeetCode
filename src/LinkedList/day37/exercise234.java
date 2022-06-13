package LinkedList.day37;

import org.junit.Test;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-12 15:31
 */
public class exercise234 {
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

    //法1 快慢指针 找到中间，将后半部分反转
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode mid = getMiddle(head);
        ListNode newHead = mid.next;
        mid.next = null;
        ListNode list1 = head;
        ListNode list2 = reverse(newHead);
        while (list1 != null && list2 != null)
        {
            if (list1.val != list2.val) return false;
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode newHead) {
        if (newHead == null || newHead.next == null)
        {
            return newHead;
        }
        ListNode node = null;
        ListNode cur = newHead;
        while (cur.next != null)
        {
            ListNode temp = cur.next;
            cur.next = node;
            node = cur;
            cur = temp;
        }
        return node;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //法2 递归
    private ListNode frontPtr;
    public boolean isPalindrome1(ListNode head)
    {
        frontPtr = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head != null)
        {
            if(!dfs(head.next))//递归从后往前返回
            {
                return false;
            }
            if (head.val != frontPtr.val)//比较这一层的值
            {
                return false;
            }
            frontPtr = frontPtr.next;//头指针往后移动
        }
        return true;
    }
}
