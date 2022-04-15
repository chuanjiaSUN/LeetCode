package Interview;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-24 15:16
 */
public class LongestSubString {
    public int longestSubstring(String s, int k) {
        int n  = s.length();
        int ret = 0;

        for (int t = 1; t <= 26; t++){
            int left = 0, right = 0;
            int[] cnt = new int[26];
            int total = 0;
            int less = 0;

            while (right < n){
                cnt[s.charAt(right) - 'a']++;
                if (cnt[s.charAt(right) - 'a'] == 1){
                    total++;
                    less++;
                }
                if (cnt[s.charAt(right) - 'a'] == k){
                    less--;
                }

                while (total > t){
                    cnt[s.charAt(left) - 'a']--;
                    if (cnt[s.charAt(left) - 'a'] == k - 1){
                        less++;
                    }
                    if (cnt[s.charAt(left) - 'a'] == 0){
                        total--;
                        less--;
                    }
                    left++;
                }

                if (less == 0){
                    ret = Math.max(ret, right - left + 1);
                }
                right++;
            }
        }
        return ret;
    }
}
