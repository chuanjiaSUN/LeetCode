package LinkedList.day32;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-07 10:34
 */
public class exercise23_practice {
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

    //分治合并
    public ListNode mergeKLists(ListNode[] lists)
    {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if( start == end )
        {
            return lists[start];
        }
        if( start > end )
        {
            return null;
        }
        int mid = (start + end) >> 1;
        return mergeTwoList(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        if( left == null || right == null)
        {
            return left != null ? left : right;
        }
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while ( left != null && right != null)
        {
            if(left.val < right.val)
            {
                dummy.next = left;
                left = left.next;
            }else
            {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left != null ? left : right;
        return head.next;
    }

}
