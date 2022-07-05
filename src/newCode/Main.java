package newCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main test = new Main();
        for (int j = 0; j < n; j++){
            int[] nums = new int[6];
            for (int i = 0; i < 6; i++){
                nums[i] = sc.nextInt();
            }
            test.help(nums);
        }
    }

    public void help(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), ans);
        boolean flag = false;
        for (List<Integer> path : ans){
            if (check(nums, path)){
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    private boolean check(int[] nums, List<Integer> path) {
        int i = path.get(0), j = path.get(1), k = path.get(2);
        int l = -1, m = -1, n = -1;
        for (int index = 0; index < 6; index++){
            if (i == index || j == index || k == index){
                continue;
            }
            if (l == -1){
                l = index;
            }else if (m == -1){
                m = index;
            }else if (n == -1){
                n = index;
            }
        }
        if (nums[i] + nums[j] > nums[k] && nums[i] - nums[j] < nums[k]){
            if (nums[l] + nums[m] > nums[n] && nums[l] - nums[m] < nums[n]){
                return true;
            }
        }
        return false;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> objects, List<List<Integer>> ans) {
        if (objects.size() == 3){
            ans.add(new ArrayList<Integer>(objects));
            return;
        }
        if (index >= 6){
            return;
        }
        dfs(nums, index + 1, objects, ans);
        objects.add(index);
        dfs(nums, index + 1, objects, ans);
        objects.remove(objects.size() - 1);
    }


}