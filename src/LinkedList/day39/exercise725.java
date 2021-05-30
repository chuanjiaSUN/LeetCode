package LinkedList.day39;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-14 10:28
 */
public class exercise725 {
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
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    //法1 建新表
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null)
        {
            N++;
            cur = cur.next;
        }
        int width = N / k, rem = N % k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for(int i = 0; i < k ; i++)
        {
            ListNode head = new ListNode(0), write = head;
            for(int j = 0; j < width + ( i < rem ? 1 : 0); j++)
            {
                write = write.next = new ListNode(cur.val);
                if(cur != null) cur = cur.next;
            }
            res[i] = head.next;
        }
        return res;
    }
    //法2 拆分链表
    public ListNode[] splitListToParts1(ListNode root, int k)
    {
        ListNode cur = root;
        int length = 0;
        while (cur != null)
        {
            length++;
            cur = cur.next;
        }
        cur = root;
        int width = length / k, rest = length % k;
        ListNode[] res = new ListNode[k];
        for(int i = 0; i < k; i++)
        {
            ListNode head = cur;
            for(int j = 0; j < width + ( i < rest ? 1 : 0) - 1; j++)
            {
                if(cur != null) cur = cur.next;
            }
            if(cur != null)
            {
                ListNode pre = cur;
                cur = cur.next;
                pre.next = null;
            }
            res[i] = head;
        }
        return res;
    }
}
