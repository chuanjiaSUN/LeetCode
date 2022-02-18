package num100;


/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 13:39
 */
public class Exe5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] array = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) {
                    break;
                }
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    //中心扩散
    public String longestPalindrome1(String s) {
        if (null == s || s.length() < 1){
            return "";
        }
        int start = 0, end = 0;
        int len = s. length();
        for (int i = 0; i <len; i++){
            int len1 = expandMid(s, i, i);
            int len2 = expandMid(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start){
                start = i - (max - 1)/ 2;
                end = i + max/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandMid(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
