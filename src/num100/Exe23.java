package num100;

import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-19 14:31
 */
public class Exe23 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
        }
    }

    /**
     * 法1 顺序合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode ans = null;

        for (int i = 0; i < len; i++) {
            ans = mergeTwo(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        ListNode cur = new ListNode();
        ListNode ans = cur;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                ans.next = a;
                a = a.next;
            } else {
                ans.next = b;
                b = b.next;
            }
            ans = ans.next;
        }
        ans.next = (a == null ? b : a);
        return cur.next;
    }

    /**
     * 法2 分治合并
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return mergeLog(lists, 0, lists.length - 1);
    }

    private ListNode mergeLog(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwo(mergeLog(lists, l, mid), mergeLog(lists, mid + 1, r));
    }

    /**
     * 法3 优先队列
     */
    class Status implements Comparable<Status> {
        int val;
        ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++){
            queue.offer(new Status(lists[i].val, lists[i]));
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!queue.isEmpty()){
            Status f = queue.poll();
            cur.next = f.node;
            cur = cur.next;
            if (f.node.next != null){
                queue.offer(new Status(f.node.next.val, f.node.next));
            }
        }
        return dummy.next;
    }
}
