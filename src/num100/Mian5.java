package num100;
import java.util.*;
/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-01 14:47
 */
public class Mian5 {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        sc.nextLine();
        int idx = 0;
        while(sc.hasNext()){
            x[idx] = sc.nextInt();
            y[idx] = sc.nextInt();
            idx++;
            sc.nextLine();
        }
        double res = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n && j != i; i++){
                double x1 = (x[i] + x[j]) / 2.0;
                double y1 = (y[i] + y[j]) / 2.0;
                res = Math.max(res, Math.min(x1, y1));
            }
        }

        System.out.println(res);
    }
}
