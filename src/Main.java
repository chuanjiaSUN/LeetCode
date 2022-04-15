import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        long[] dp = new long[chars.length];
        int len = chars.length;
        dp[1] = (chars[1] == chars[0] || Math.abs(chars[1] - chars[0]) == 1) ? chars[0] + chars[1] - 2 * 'a' + 2 : 0;
        long res = 0;
        for (int i = 2; i < len; i++){
            for (int j = 0; j < i - 1; j++){
                if (chars[i] == chars[i - 1] || Math.abs(chars[i - 1] - chars[i]) == 1){
                    dp[i] = Math.max(dp[i], dp[j] + chars[i] + chars[i - 1] - 'a' - 'a' + 2);
                }
                res = Math.max(res, dp[i]);
            }
        }

        System.out.println(dp[len - 1]);

    }
}