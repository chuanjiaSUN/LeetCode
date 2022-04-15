package Interview;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-27 14:05
 */
public class WangYi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        long[] dp = new long[arr.length];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 1; i < arr.length; i++){
            if(i > 2){
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }else if(i > 1){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[arr.length - 1]);
    }
}
