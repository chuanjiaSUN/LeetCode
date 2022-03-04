package num100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-02 11:54
 */
public class Mian9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int left = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        boolean find = false;

        for(int right = 0; right < n; right++){
            int count = map.getOrDefault(a[right], 0);
            count++;
            map.put(a[right], count);
            if (count == m){
                find = true;
            }
            while (find && left < n && right < n && left <= right){
                ans += n - right;
                int leftCount = map.get(a[left]);
                leftCount--;
                map.put(a[left], leftCount);
                if (a[left] == a[right] && leftCount < m){
                    find = false;
                }
                left++;
            }
        }
        System.out.println(ans);
    }
}
