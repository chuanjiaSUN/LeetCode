package Interview;

import com.sun.media.sound.RIFFInvalidDataException;
import sun.management.Sensor;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-20 16:09
 */
public class LeetCode {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int first = 0; first < len; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int third = len - 1;
            while (second < third) {
                if (nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                } else if (nums[first] + nums[second] + nums[third] < 0) {
                    second++;
                } else {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[first]);
                    path.add(second);
                    path.add(third);
                    ans.add(new ArrayList<>(path));

                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    third--;
                    second++;
                }
            }
        }

        return ans;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int first = 0; first < len - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            if ((long) nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if ((long) nums[first] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target){
                continue;
            }
            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if ((long)nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target){
                    break;
                }
                if ((long)nums[first] + nums[second] + nums[len - 2] + nums[len - 1] < target){
                    continue;
                }

                int left = second + 1;
                int right = len - 1;
                while (left < right){
                    if (nums[first] + nums[second] + nums[left] + nums[right] > target){
                        right--;
                    }else if (nums[first] + nums[second] + nums[left] + nums[right] < target){
                        left++;
                    }else{
                        List<Integer> path = new ArrayList<>();
                        path.add(nums[first]);
                        path.add(nums[second]);
                        path.add(nums[left]);
                        path.add(nums[right]);
                        ans.add(path);
                        while (left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        int temp;
        int res = 0;

        for (int i : nums1){
            for (int j : nums2){
                temp = i + j;
                if (map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                }else{
                    map.put(temp, 1);
                }
            }
        }

        for (int i : nums3){
            for(int j : nums4){
                temp = i + j;
                if (map.containsKey(-temp)){
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++){
            int left = i;
            while (nums[i] == val){
                i++;
            }
            if (i > left){
                travel(nums,left, i, len - 1);
                ans += i - left;
            }

        }
        return len - ans;
    }

    private void travel(int[] nums, int left, int start, int end) {
        while (start <= end){
            nums[left++] = nums[start++];
        }
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int len1 = g.length, len2 = s.length;
        int ans = 0;

        int l = 0, r = 0;
        while (l < len2 && r < len1){
            if (s[l] >= s[r]){
                l++;
                r++;
                ans++;
            }else{
                l++;
            }
        }
        return ans;
    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < len; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
            for (int j = 0; j < i; j++){
                if (nums[i] < nums[j]){
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
