package LinkedList.day36;

import LinkedList.day35.exercise142;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-11 11:34
 */


public class exercise143 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
    public void reorderList(ListNode head) {
        if (head == null) return;
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode cur = head;
        while (cur != null)
        {
            map.put(index,cur);
            cur = cur.next;
            index++;
        }
        cur = head;
        for(int i = 0; i < index/2; i++)
        {
            ListNode next = cur.next;
            ListNode tail = map.get(index - i - 1);
            ListNode pre = map.get(index - i - 2);
            cur.next = tail;
            tail.next = next;
            pre.next = null;
            cur = next;
        }
    }

    // 使用线性表存储
    public void reorderList1(ListNode head)
    {
        if(head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null)
        {
            list.add(cur);
            cur = cur.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j)
        {
            list.get(i).next = list.get(j);
            i++;
            if( i==j)break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
    //法3 寻找链表中点，链表逆序，合并链表
    public void reorderList2(ListNode head)
    {
        if(head == null) return;
        ListNode mid = getMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;//断开左右链表的连接
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    //分开合并
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_temp;
        ListNode l2_temp;
        while (l1 != null && l2 != null)
        {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;

            l2.next = l1;
            l2 = l2_temp;
        }
    }

    //头插法反转链表

//    private ListNode reverseList(ListNode head) {
//        ListNode dummy = new ListNode(0,head);
//        ListNode pre = dummy;
//        ListNode cur = pre.next;
//        while (cur.next != null)
//        {
//            ListNode nex = cur.next;
//            cur.next = nex.next;
//            nex.next = pre.next;
//            pre.next = nex;
//        }
//        return dummy.next;
//    }

    //反向反转
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode getMid(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
