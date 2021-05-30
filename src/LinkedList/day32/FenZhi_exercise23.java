package LinkedList.day32;

import LinkedList.day31.exercise21;

import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @create 2021-04-07 9:46
 */
public class FenZhi_exercise23 {
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
    //法1 顺序合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(int i = 0; i < lists.length; i++)
        {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if( a == null || b == null)
        {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while ( aPtr != null && bPtr != null)
        {
            if( aPtr.val < bPtr.val)
            {
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else{
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = ( aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    //法2 分治合并
    public ListNode mergeKLists1(ListNode[] lists)
    {
        return merge(lists, 0, lists.length -1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if( l == r)
        {
            return lists[l];
        }
        if( l > r)
        {
            return null;
        }
        int mid = (l + r) >> 1;
        return  mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    //法3 优先队列
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr)
        {
            this.val = val;
            this.ptr = ptr;
        }
        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();//优先队列

    public ListNode mergeKLists2(ListNode[] lists)
    {
        for(ListNode node : lists)
        {
            if( node != null)
            {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while ( !queue.isEmpty())
        {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if(f.ptr.next != null)
            {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }

}
