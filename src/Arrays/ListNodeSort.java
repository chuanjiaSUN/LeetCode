package Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-04-15 16:17
 */
public class ListNodeSort {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 自底向上归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode prev = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode sorted = merge(head1, head2);
                prev.next = sorted;
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dummy.next;


    }


    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode dummyHead = dummy, head1 = left, head2 = right;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                dummyHead.next = head1;
                head1 = head1.next;
            } else {
                dummyHead.next = head2;
                head2 = head2.next;
            }
            dummyHead = dummyHead.next;
        }
        if (head1 != null) {
            dummyHead.next = head1;
        }
        if (head2 != null) {
            dummyHead.next = head2;
        }

        return dummy.next;
    }

    /**自顶向下归并
     * */
    public ListNode sortList1(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return merge(mergeSort(head), mergeSort(head2));
    }

    /**链表快排
     * */
    public ListNode sortList2(ListNode head){
        return fastSort(head)[0];
    }

    private ListNode[] fastSort(ListNode head) {
        if (head == null || head.next == null){
            return new ListNode[]{head, head};
        }

        ListNode pivot = head.next, headSmall = new ListNode(), headBig = new ListNode();
        ListNode tailSmall = headSmall, tailBig = headBig;
        while (pivot != null){
            if (pivot.val < head.val){
                tailSmall.next = pivot;
                tailSmall = tailSmall.next;
            }else{
                tailBig.next = pivot;
                tailBig = tailBig.next;
            }
            pivot = pivot.next;
        }
        head.next = null;
        tailBig.next = null;
        tailSmall.next = null;

        ListNode[] left = fastSort(headSmall.next);
        ListNode[] right = fastSort(headBig.next);

        if (left[1] != null){
            left[1].next = head;
        }
        head.next = right[0];

        ListNode newHead, newTail;
        if (left[0] != null) {
            newHead = left[0];
        } else {
            newHead = head;
        }
        if (right[1] != null) {
            newTail = right[1];
        } else {
            newTail = head;
        }

        return new ListNode[]{newHead, newTail};

    }
}
