import javax.swing.event.DocumentEvent;
import java.util.*;

public class Main{
    public static void main(String[] args) {

    }
    boolean[][] vis;
    int res;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int ncov_defect (int[][] grid) {
        if (grid == null || grid.length == 0){
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    for (int[] dir : directions){
                        int newX = i + dir[0];
                        int newY = j + dir[1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n){
                            if (!vis[newX][newY] && grid[newX][newY] == 0){
                                res++;
                                vis[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public int nucleicAcidTestWay (int n) {
        // write code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode reverseBetween (ListNode head) {
        // write code here
        ListNode dummy = head;
        ListNode cur = dummy;
        cur = cur.next;
        ListNode pre = cur;
        for (int i = 0; i < 4; i++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        ListNode tail = cur;
        cur = pre.next;
        ListNode ans = reverse(cur, tail, next);
        pre.next = ans;
        return dummy;
    }

    private ListNode reverse(ListNode head, ListNode tail, ListNode next) {
        ListNode pre = next;
        while (head != tail){
            ListNode nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        head.next = pre;
        return head;
    }
}