package num100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-01 20:34
 */
public class Mian7 {

    //完全背包问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if (a[i] < 1 || a[i] > 1000000)return;
        }

        int k = sc.nextInt();
        int[] v = new int[n];
        Arrays.fill(v, 1);

        for (int i = 0; i < k; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x - 1] += a[y - 1];
            v[x - 1] += 1;
            v[y - 1] = 0;
        }

        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++){
            if (v[i] == 0) continue;

            for (int j = m; j > a[i] - 1; j--){
                dp[j] = Math.max(dp[j], (dp[j - a[i]] + v[i]));
            }
        }

        System.out.println(dp[m]);

    }
}
