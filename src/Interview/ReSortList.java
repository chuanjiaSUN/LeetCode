package Interview;

import num100.Mian3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-22 21:49
 */
public class ReSortList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }

        int len = list.size();
        int left = 0, right = len - 1;

         cur = head;
        while (left < right){
            list.get(left).next = list.get(right);
            left++;
            if (left == right)break;
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(right).next = null;
    }
}
