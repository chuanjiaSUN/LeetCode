package newCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-04 18:49
 */
public class Main {


    public static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        List<int[]> list = new ArrayList<>();
        used = new boolean[n];
        getPath(nums, 0, new int[n], list);


        int max = 0;

        int[][] operation = new int[m][4];

        for (int i = 0; i < m; i++){
            int opera = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            operation[i][0] = opera;
            operation[i][1] = start;
            operation[i][2] = end;
            if (opera == 2){
                operation[i][3] = sc.nextInt();
            }
        }
        for (int[] arr : list){
            for (int num : arr){
                System.out.print(num);
            }
            System.out.println();
            int res = 0;
            for (int i = 0; i < m; i++){
                int opera = operation[i][0];
                int start = operation[i][1];
                int end = operation[i][2];
                if (opera == 1){
                    int ans = getSum(arr, start, end);
                    System.out.println(ans);
                    res += ans;
                }else if (opera == 2){
                    int k = operation[i][3];
                    add(arr, start, end, k);
                }
            }
            max = Math.max(max, res);
        }


        System.out.println(max);

    }

    private static void getPath(int[] nums, int idx, int[] path, List<int[]> list) {
        if (idx == nums.length){
            list.add(Arrays.stream(path).toArray());
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                used[i] = true;
                path[idx] = nums[i];
                getPath(nums, idx + 1, path, list);
                path[idx] = 0;
                used[i] = false;
            }
        }
    }

    private static void add(int[] nums, int start, int end, int k) {
        for (int i = start; i <= end; i++){
            nums[i - 1] = nums[i - 1] + k;
        }
    }

    private static int getSum(int[] nums, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++){
            res += nums[i - 1];
        }
        return res;
    }
}
