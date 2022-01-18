package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-01-18 13:37
 */
public class Again881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int length = people.length;
        int ans = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            ans++;
        }
        return ans;
    }
}
