package LinkedList.day33;

import LinkedList.day32.FenZhi_exercise23;

import java.util.Random;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-08 12:53
 */
public class exercise61 {
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
    //闭合为环，再断开
    public ListNode rotateRight(ListNode head, int k) {
       if(k==0 || head == null || head.next == null) return head;
       int n = 1;
       ListNode tail = head;
       while (tail.next != null)
       {
           tail = tail.next;
           n++;
       }
       int add =  n - k % n;//新链表最后一个结点
       if( add == n) return head;
       tail.next = head;//连接为环
        while ( add-- > 0)
        {
            tail = tail.next;
        }
        ListNode ret = tail.next;
        tail.next = null;
        return ret;
    }


}
