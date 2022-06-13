package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-13 22:11
 */
public class Pre21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode();
        ListNode dummy = cur;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if (list1 != null){
            dummy.next = list1;
        }else if (list2 != null){
            dummy.next = list2;
        }
        return cur.next;
    }
}
