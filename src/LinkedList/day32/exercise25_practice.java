package LinkedList.day32;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-07 12:05
 */
public class exercise25_practice {
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
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (head != null)
        {
            ListNode tail = pre;//子链表的尾结点
            //判断后序子链表是否满足长度
            for(int i = 0; i < k; i++)
            {
                tail = tail.next;
                if(tail == null)return dummy.next;
            }
            ListNode nex = tail.next;//下一个子链表的开头
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //连接子链表
            pre.next = head;
            tail.next = nex;
            pre = tail;//更新下一个子链表的前驱
            head = tail.next;//更新下一个子链表的头结点
        }
        return dummy.next;
    }

    //翻转子链表
    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode next = tail.next;
        ListNode curNode = head;
        while (next != tail)
        {
            ListNode nextChangeNode = curNode.next;
            curNode.next = next;
            next = curNode;
            curNode = nextChangeNode;
        }
        return new ListNode[]{tail, head};
    }

}
