package LinkedList.day37;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-12 16:20
 */
public class exercise237 {
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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
