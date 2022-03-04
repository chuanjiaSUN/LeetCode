package num100;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-02 12:30
 */
public class Mian10 {
    /**
     * DP编辑距离问题
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(sc.nextInt(), i);
        }

        for (int i = 0; i < n; i++){
            a[i] = map.get(a[i]);
        }

        int max = 1;
        int cur = 1;
        for (int i = 0; i < n - 1; i++){
            if (a[i] < a[i + 1]){
                cur++;
                max = Math.max(max, cur);
            }else{
                cur = 1;
            }
        }
        System.out.println(n - max);
    }
}
