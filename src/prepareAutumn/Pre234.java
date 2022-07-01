package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-01 22:37
 */
public class Pre234 {
    ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head != null){
            if (!dfs(head.next)){
                return false;
            }
            if (head.val != front.val){
                return false;
            }
            front = front.next;
        }
        return true;
    }
}
