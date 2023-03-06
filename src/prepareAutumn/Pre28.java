package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-30 18:51
 */
public class Pre28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0){
            return 0;
        }
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++){
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j =0; i < m; i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == n){
                return i - n + 1;
            }
        }
        return -1;
    }
    /**
     * practice
     * */
    public int strStr1(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] next = new int[n];
        for(int i = 1, j = 0; i < n; i++){
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j += 1;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < m; i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == n){
                return i - n + 1;
            }
        }
        return -1;
    }
}
