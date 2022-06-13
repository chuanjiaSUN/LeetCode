package LinkedList.day39;

import LinkedList.day38.exercise445;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-14 9:20
 */
public class MyLinkedList{
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

    int size;
    ListNode head;//前驱指针、哨兵
    public MyLinkedList()
    {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if(index < 0 || index >= size ) return -1;
        ListNode cur = head;
        for(int i = 0 ; i < index + 1; ++i)
        {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        size++;
        ListNode pred = head;
        for(int i = 0; i < index ; i++)
        {
            pred = pred.next;
        }
        ListNode added = new ListNode(val);
        added.next = pred.next;
        pred.next = added;

    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        size--;
        ListNode prev = head;
        for(int i = 0; i < index; i++)
        {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

}
