package LinkedList.day31;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-06 15:20
 */
public class exercise21 {
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
    //法1 迭代  原地合并，时间O(N),空间O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while( l1 != null && l2 != null)
        {
            if( l1.val <= l2.val)
            {
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;//合并后至多只有一个没被合并完
        return preHead.next;
    }
    //法2 递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2)
    {
        if( l1 == null )
        {
            return l2;
        }else if(l2 == null)
        {
            return l1;
        }else if( l1.val < l2.val)
        {
            l1.next = mergeTwoLists1(l1.next, l2);//每一次递归，将更小的值所在结点 付给 当前节点的 Next
            return l1;
        }else
        {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

}
