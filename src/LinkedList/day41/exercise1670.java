package LinkedList.day41;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-16 10:39
 */
public class exercise1670 {
    ListNode top; // 首部的哑节点
    ListNode tail; // 尾部的哑节点
    ListNode mid; // 用于记录中间节点位置的指针
    int length; // 记录双向链表长度

    class ListNode{
        int val;
        ListNode last;
        ListNode next;
        public ListNode(){};
        public ListNode(int val){this.val = val;};
    }
    public exercise1670() {
        // 创建首尾的哑节点，并连接在一起
        top = new ListNode(0);
        tail = new ListNode(0);
        top.next = tail;
        tail.last = top;

        length = 0;
    }

    public void pushFront(int val) {
        ListNode node = new ListNode(val);
        // 先该节点的next指向双向链变的第一个节点（即top.next）
        // 再双向链变的第一个节点（top.next）的last指向该节点
        node.next = top.next;
        top.next.last = node;
        // 该节点与首节点连接在一起
        node.last = top;
        top.next = node;

        length++;

        // 修改mid指针的位置
        if(length == 1){
            // 说明时第一个节点，那么mid就是它
            mid = node;
        }else if(length % 2 == 0){
            // 那么mid往前移一位
            mid = mid.last;
        }
        // System.out.println("pushFront:" + length);
    }

    public void pushMiddle(int val) {
        if(length == 0){
            pushFront(val);
        }else{
            ListNode node = new ListNode(val);

            if(length % 2 == 0){
                // 偶数放mid后面
                node.next = mid.next;
                mid.next.last = node;
                mid.next = node;
                node.last = mid;
            }else{
                // 奇数放mid前面
                node.last = mid.last;
                mid.last.next = node;
                node.next = mid;
                mid.last = node;
            }


            length++;

            // 修改mid指针位置
            if(length % 2 == 0){
                mid = mid.last;
            }else{
                mid = mid.next;
            }
            // System.out.println("pushMiddle:" + length);
        }
    }

    public void pushBack(int val) {
        ListNode node = new ListNode(val);
        // 该节点的last先指向双向链表的最后一个节点（即tail.last）
        // 双向链表的最后一个节点（tail.last）的next再指向该节点
        node.last = tail.last;
        tail.last.next = node;
        // 该节点再与尾节点连接在一起
        node.next = tail;
        tail.last = node;

        length++;

        // 修改mid的位置
        if(length == 1){
            mid = node;
        }else if(length % 2 != 0){
            // 那么mid往后移一位
            mid = mid.next;
        }
        // System.out.println("pushBack:" + length);
    }

    public int popFront() {
        int ret = -1;
        if(length != 0){
            // 当双向链表不为空时
            // 删除双向链表的第一个节点，只要让首节点与第二个节点连接在一起即可
            ret = top.next.val; // 记录返回值
            top.next.next.last = top;
            top.next = top.next.next;

            length--;

            // 修改mid指针位置
            if(length == 0){
                mid = null;
            }else if(length % 2 != 0){
                mid = mid.next;
            }
            // System.out.println("popFront:" + length);
        }

        return ret;
    }

    public int popMiddle() {
        int ret = -1;
        if(length != 0){
            ret = mid.val;
            mid.next.last = mid.last;
            mid.last.next = mid.next;

            length--;

            // 修改mid指针位置
            if(length % 2 == 0){
                mid = mid.last;
            }else{
                mid = mid.next;
            }
            // System.out.println("popMiddle:" + length);
        }

        return ret;
    }

    public int popBack() {
        int ret = -1;
        if(length != 0){
            // 当双向链表不为空时
            // 删除双向链表的最后一个节点，只需要让尾节点与倒数第二个节点连接在一起即可
            ret = tail.last.val;
            tail.last.last.next = tail;
            tail.last = tail.last.last;

            length--;

            // 修改mid指针位置
            if(length == 0){
                mid = null;
            }else if(length % 2 == 0){
                mid = mid.last;
            }
            // System.out.println("popBack:" + length);
        }

        return ret;
    }
}
