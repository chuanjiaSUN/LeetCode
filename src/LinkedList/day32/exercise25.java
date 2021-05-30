package LinkedList.day32;

import java.sql.Time;

/**
 * @author sunchuanjia
 * @Description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @create 2021-04-07 11:27
 */
public class exercise25 {
    class ListNode{
        private int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val)
        {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//指向头结点的前驱

        while ( head != null)
        {
            ListNode tail = pre;//尾结点
            //查看剩余部分长度是否够k
            for(int i = 0 ; i < k; i++)
            {
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;//记录最后一个节点的下一个节点
            ListNode[] reverse = myReverse( head, tail);
            head = reverse[0];
            tail = reverse[1];
            //连接子链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;//要换方向的结点
        while ( prev != tail)
        {
            ListNode nex = p.next;//下一个要换方向的结点
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
