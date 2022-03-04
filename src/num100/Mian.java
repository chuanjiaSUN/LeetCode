package num100;

import java.util.*;
/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-28 16:32
 */
public class Mian {
    public static class Good implements Comparable{
        public int x;
        public int y;

        public Good(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o){
            Good good = (Good)o;
            if(this.x > good.x){
                return 1;
            }else if(this.x  < good.x){
                return -1;
            }else{
                if(this.y > good.y){
                    return -1;
                }else if(this.y < good.y){
                    return 1;
                }
            }
            return 0;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(sc.hasNext()){
            sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i = 0; i < n; i++){
                x[i] = sc.nextInt();
            }
            sc.nextLine();
            for(int i = 0; i < n; i++){
                y[i] = sc.nextInt();
            }

            Good[] goods = new Good[n];
            for (int i = 0; i < n; i++){
                goods[i] = new Good(x[i], y[i]);
            }
            Arrays.sort(goods);

            dp(goods);
            binary(goods);
        }
}

    private static void dp(Good[] arr) {
        int max = 0;
        int len = arr.length;
        int[] value = new int[len];

        for (int i = 0; i < len; i++){
            value[i] = 1;

            for (int j = 0; j < i; j++){
                if (arr[j].y < arr[i].y){
                    value[i] = Math.max(value[i], value[j] + 1);
                }
            }
            max = Math.max(max, value[i]);
        }
        System.out.println(max);
    }

    private static void binary(Good[] goods) {
        int len = goods.length;
        int[] value = new int[goods.length + 1];

        int max = 1;
        value[1] = goods[0].y;
        for (int i = 1; i < len; i++){
            if (goods[i].y > value[max]){
                value[++max] = goods[i].y;
            }else{
                int t = find(value, max, goods[i].y);
                value[t] = goods[i].y;
            }
        }
        System.out.println(max);
    }

    private static int find(int[] value, int max, int i) {
        int l = 1, r = max;
        while (l  <= r){
            int mid = (l + r) >> 1;

            if (i > value[mid]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
