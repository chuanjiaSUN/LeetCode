package Interview;

import num100.Mian3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-22 14:57
 */
public class IdeaAni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            int temp = m;

            while (temp > 0){
                int k = sc.nextInt();
                for (int i = 0; i < k; i++){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = x - 1; j < y; j++){
                        arr[j]++;
                    }
                }
                temp--;
            }

            int ans = 0;
            for (int k = 0; k < n; k++){
                if (arr[k] >= m){
                    ans++;
                    System.out.print(k + 1 + " ");
                }
            }
            t--;
        }
    }
}
