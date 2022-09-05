package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-05 15:37
 */
public class Pre143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int len = list.size();
            int i = 0, j = len - 1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if (i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
    }
}
