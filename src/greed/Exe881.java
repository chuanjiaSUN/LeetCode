package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-26 13:15
 */
public class Exe881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int ans = 0;
        int left = 0, right = n  - 1;
        while (left < right)
        {
            if (people[left] + people[right] <= limit)
            {
                left++;
            }
            right--;
            ans++;
        }
        return ans;
    }
}
