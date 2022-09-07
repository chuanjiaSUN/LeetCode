import java.util.*;

public class Main{
    public static void main(String[] args) {
        int[] nums = {1344, 2000, 2311, 4211, 3211, 2500};
        Main main = new Main();
        int[] ints = main.get(nums, 3);
        for (int num : ints){
            System.out.println(num);
        }
    }

    public int[] get(int[] nums, int k){
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++){
            list.add(nums[i]);
        }
        int median0 = 0;
        int median1 = 0;
        if (k % 2 == 0){
            median0 = k / 2 - 1;
            median1 = k / 2;
        }else{
            median0 = k / 2;
            median1 = k / 2;
        }
        int[] ans = new int[len - k + 1];
        list.sort((o1, o2) -> o1 - o2);
        int index = 0;
        int median = getMedian(list, median0, median1);
        if (Math.abs(list.get(0) -  median) < Math.abs(list.get(k - 1) - median)){
            ans[index++] = list.get(k - 1);
        }else{
            ans[index++] = list.get(0);
        }
        for (int i = k; i < len; i++){
            List<Integer> subList = list.subList(1, k);
            subList.add(nums[i]);
            subList.sort((o1, o2) -> o1 - o2);
            median = getMedian(subList, median0, median1);
            if (Math.abs(subList.get(0) -  median) < Math.abs(subList.get(k - 1) - median)){
                ans[index++] = subList.get(k - 1);
            }else{
                ans[index++] = subList.get(0);
            }
            list = new ArrayList<>(subList);
        }
        return ans;
    }

    private int getMedian(List<Integer> list, int median0, int median1) {
        return (list.get(median0) + list.get(median1)) / 2;
    }
}