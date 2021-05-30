package LinkedList.day39;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-14 9:58
 */
public class MyLinkedList1 {
    int size;
    ListNode head,tail;//伪头、伪尾
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
        ListNode(int val, ListNode next, ListNode prev){this.val = val; this.next = next;this.prev = prev;}

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public MyLinkedList1()
    {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index)
    {
        if(index < 0 || index >= size) return -1;
        ListNode cur = head;
        if( index + 1 < size - index)
        {
            for(int i = 0; i < index + 1; i++)
            {
                cur = cur.next;
            }
        }else{
            cur = tail;
            for(int i = 0; i < size - index; i++)
            {
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val)
    {
        ListNode pred = head;
        ListNode cur = head.next;
        size++;
        ListNode added = new ListNode(val);
        added.prev = head;
        added.next = cur;
        pred.next = added;
        cur.prev = added;
    }
    public void addAtTail(int val)
    {
        ListNode pre = tail.prev;
        ListNode cur = tail;
        size++;
        ListNode added = new ListNode(val);
        added.prev = pre;
        added.next = cur;
        pre.next = added;
        cur.prev = added;
    }
    public void addAtIndex(int index, int val)
    {
        if(index > size) return;
        if (index < 0 ) index = 0;
        ListNode pre, cur;
        if( index < size - index)
        {
            pre = head;
            for(int i = 0; i < index; i++)
            {
                pre = pre.next;
            }
            cur = pre.next;
        }else{
            cur = tail;
            for(int i = 0; i <size - index; i++)
            {
                cur = cur.prev;
            }
            pre = cur.prev;
        }
        ListNode added = new ListNode(val);
        size++;
        added.prev = pre;
        added.next = cur;
        pre.next = added;
        cur.prev = added;
    }
    public void deleteAtIndex(int index)
    {
        if(index < 0 || index >= size) return;
        ListNode pre, cur;
        if(index < size - index)
        {
            pre = head;
            for(int i = 0; i < index; i++)
            {
                pre = pre.next;
            }
            cur = pre.next.next;
        }else{
            cur = tail;
            for(int i = 0; i < size - index - 1; i++)
            {
                cur = cur.prev;
            }
            pre = cur.prev.prev;
        }
        size--;
        pre.next = cur;
        cur.prev = pre;
    }
}
