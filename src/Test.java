import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-17 14:09
 */
public class Test {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * wizer
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10],
     *
     * target = 8
     * */

    public int[] find(int[] nums, int target){
        int n = nums.length;
        int[] ans = new int[2];

        int l = Integer.MAX_VALUE , r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (nums[i] == target && i < l){
                l = i;
            }else if (nums[i] == target && i > r){
                r = i;
            }
        }
        ans[0] = (l == Integer.MAX_VALUE ? -1 : l);
        if (r == Integer.MIN_VALUE){
            if (l != Integer.MAX_VALUE){
                ans[1] = l;
            }else{
                ans[1] = -1;
            }
        }else{
            ans[1] = r;
        }

        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        long[] nums = new long[]{2,1,3,2};
//        int ans = test.getAns(nums);
//        System.out.println(ans);

        test.delMember();


    }

    public int getAns(long[] nums){
        int n = nums.length;
        long[] left_max = new long[n];
        left_max[0] = Integer.MIN_VALUE;
        long[] right_min = new long[n];
        right_min[n - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            left_max[i] = Math.max(left_max[i - 1], nums[i - 1]);
            System.out.println(left_max[i]);
        }
        for (int i = n - 2; i >= 0; i--){
            right_min[i] = Math.min(right_min[i + 1], nums[i + 1]);
            System.out.println(right_min[i]);
        }

        long max = nums[0], min = nums[0];
        int ans = 0;
        boolean begin = true;
        int end = -1;

        for (int i = 0; i < n; i++){
            if (begin){
                max = nums[i];
                min = nums[i];
                begin = false;
            }else{
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            if (min >= left_max[end + 1] && max <= right_min[i]){
                end = i;
                ans++;
                begin = true;
            }
        }

        return ans;
    }

    public void delMember(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] rel = new int[m][2];
        int[] count = new int[2 * n];
        for (int i = 0; i < m; i++){
            rel[i][0] = sc.nextInt();
            rel[i][1] = sc.nextInt();

            count[rel[i][0] - 1] ++;
            count[rel[i][1] - 1] ++;
        }

        int del = 0;
        List<Integer> out = new ArrayList<>();

        int temp = 0;
        for (int i = 0; i < m; i++){
            if (out.contains(rel[i][0]) || out.contains(rel[i][1])){
                continue;
            }

            if (count[rel[i][0] - 1] != count[rel[i][1] - 1]){
                temp = count[rel[i][0] - 1] > count[rel[i][1] - 1] ? rel[i][0] : rel[i][1];
            }else{
                temp = Math.max(rel[i][0], rel[i][1]);
            }

            if (!out.contains(temp)){
                out.add(temp);
                del++;
            }

        }
        System.out.println(del);

        Iterator<Integer> iterator = out.stream().sorted().iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }

}
