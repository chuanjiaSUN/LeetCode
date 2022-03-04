package CodeThinkNote.dpBag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-03 13:08
 */
public class NiuCodeALiTest7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int[] values = new int[n];
        Arrays.fill(values, 1);
        for (int i = 0; i < k; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            a[x] += a[y];
            values[x] += values[y];
            values[y] = 0;
        }

        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++){
            for (int j = a[i]; j <= m; j++){
                if (values[i] != 0){
                    dp[j] = Math.max(dp[j], dp[j - a[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[m]);

    }
}
