package String.day04;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-22 10:48
 */
public class KMP_exercise28 {
    //双指针 KMP算法  相当于需要计算next数组
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m==0) return 0;
        int[] next = new int[m];
        //计算 next数组
        for (int i = 1, j = 0; i < m; i++)
        {
            while ( j > 0 && needle.charAt(i) != needle.charAt(j))
            {
                j = next[j - 1];
            }
           if (needle.charAt(i) == needle.charAt(j))
           {
               j++; 
           }
           next[i] = j;
        }
        //匹配过程
        for (int i = 0, j = 0; i < n; i++)
        {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
            {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j))
            {
                j++;
            }
            if (j == m)
            {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP_exercise28 e = new KMP_exercise28();
        int i = e.strStr("aaaaa", "a");
        System.out.println(i);
    }
}
