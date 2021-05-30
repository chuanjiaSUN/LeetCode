package JZ_Offer_linkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-19 14:18
 */
public class offer0206 {
    static class ListNode{
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = slow.next;
        ListNode cur = list2;
        slow.next = null;
        ListNode pre = null;
        while ( cur != null)
        {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        while (pre != null && head != null)
        {
            if (pre.val != head.val)return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    //法2 递归
    private ListNode frontPtr;
    public boolean isPalindrome1(ListNode head)
    {
        frontPtr = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head != null)
        {
            if (!dfs(head.next)) return false;
            if (head.val != frontPtr.val) return false;
            frontPtr = frontPtr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(2);
        x.next.next.next = new ListNode(1);
        offer0206 e = new offer0206();
        boolean palindrome = e.isPalindrome(x);
        System.out.println(palindrome);
    }
}
