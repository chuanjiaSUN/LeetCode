package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-27 22:55
 */
public class Pre160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;

    }
}
