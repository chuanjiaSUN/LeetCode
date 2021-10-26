package greed;


import javafx.scene.layout.Priority;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-26 12:10
 */
public class ExE870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] sortedA = nums1.clone();
        Arrays.sort(sortedA);
        int[] sortedB = nums2.clone();
        Arrays.sort(sortedB);

        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int b : nums2)
        {
            assigned.put(b, new LinkedList<>());
        }
        Deque<Integer> remaining = new LinkedList<>();

        int j = 0;
        for (int a : sortedA)
        {
            if (a > sortedB[j])
            {
                assigned.get(sortedB[j++]).add(a);
            }else{
                remaining.add(a);
            }
        }

        int[] ans = new int[nums2.length];
        int n = nums2.length;
        for (int i = 0; i < n; i++)
        {
            if (assigned.get(nums2[i]).size() > 0)
            {
                ans[i] = assigned.get(nums2[i]).pop();
            }else{
                ans[i] = remaining.pop();
            }
        }
        return ans;
    }

    /**堆 + 双指针*/
    public int[] advantageCount1(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        Arrays.sort(nums1);
        PriorityQueue<int[]> nums2Sorted = new PriorityQueue<>((a, b) ->{
            return b[1] - a[1];
        });
        int index = 0;
        for (int num : nums2)
        {
            nums2Sorted.offer(new int[]{index++, num});
        }
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        while (!nums2Sorted.isEmpty())
        {
            int[] n2 = nums2Sorted.poll();
            if (nums1[right] > n2[1])
            {
                res[n2[0]] = nums1[right--];
            }else{
                res[n2[0]] = nums1[left++];
            }
        }
        return res;
    }
}
