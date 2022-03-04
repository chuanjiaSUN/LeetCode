package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-01 13:11
 */
import java.util.*;

public class Mian3{

    public static class ListNode{
        int val;
        ListNode left;
        ListNode right;

        public ListNode(){}

        public ListNode(int val, ListNode left, ListNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static long mod = (long)Math.pow(10, 9) + 7;
    private static long ans = 0l;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                for (int k = 0; k < i; k++){
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1] % mod) % mod;
                }
            }
        }
        System.out.println(dp[n][m]);
    }


}
