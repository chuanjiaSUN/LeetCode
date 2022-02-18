package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 22:16
 */
public class Exe21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null){
            cur.next = list1;
        }else if (list2 != null){
            cur.next = list2;
        }
        return dummy.next;
    }

    //递归
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (null == list1){
            return list2;
        }else if (null == list2){
            return list1;
        }else if (list1.val < list2.val){
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }
}
