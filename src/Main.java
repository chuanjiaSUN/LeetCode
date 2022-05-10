import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, m);
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = m; j >= price[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - price[i]] + price[i]);
                ans = Math.max(ans, dp[j]);
            }
        }
        System.out.println(ans);
    }

//3 2
//        1 1 4
//        6
}