package LinkedList.day34;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-09 11:34
 */
public class exercise92 {
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dummy = new ListNode(0,head);
       ListNode pre = dummy;
       ListNode leftPre = null;
        for(int i = 0; i < left -1; i++)
        {
            pre = pre.next;//来到left前一个结点
        }
        leftPre = pre;
        ListNode rightNode = pre;

        for(int i = 0; i < right - left + 1; i++)
        {
            rightNode = rightNode.next;
        }
        //截取子链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        //截断
        pre.next = null;
        rightNode.next = null;
        //反转子链表
        reverse(leftNode);

        //连接
        leftPre.next = rightNode;
        leftNode.next = cur;

        return dummy.next;
    }

    private void reverse(ListNode leftNode) {
        ListNode pre = null;
        ListNode cur = leftNode;

        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    //法2  一次遍历反转 头插法
    public ListNode reverseBetween1(ListNode head, int left, int right)
    {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        for(int i = 0 ; i < left - 1; i ++)
        {
            pre = pre.next;//找到第一个结点的前驱
        }
        ListNode cur = pre.next;
        ListNode next;
        for( int i = 0; i < right - left ; i++)
        {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

}
