package prepareAutumn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-14 21:33
 */
public class Pre23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoList(ans, list);
        }
        return ans;
    }

    public ListNode mergeTwoList(ListNode pre, ListNode tail){
        ListNode cur = null;
        ListNode dummy = new ListNode();
        cur = dummy;
        int val = 0;
        while (pre != null && tail != null){
            if (pre.val < tail.val){
                val = pre.val;
                pre = pre.next;
            }else{
                val = tail.val;
                tail = tail.next;
            }
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }
        if (pre != null){
            dummy.next = pre;
        }else if (tail != null){
            dummy.next = tail;
        }
        return cur.next;
    }

    /**法2 优先队列*/
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        priorityQueue.addAll(Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList()));
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!priorityQueue.isEmpty()){
            ListNode smaller = priorityQueue.poll();
            tail.next = smaller;
            tail = tail.next;
            if (smaller.next != null){
                priorityQueue.add(smaller);
            }
        }
        return head.next;
    }

    /**归并*/
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        if (left > right){
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }
}
