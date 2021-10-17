package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-17 13:39
 */
public class Exe767 {
    public String reorganizeString(String s){
        if (s.length() < 2)
        {
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
        {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(counts[c - 'a'], maxCount);
        }
        if (maxCount > (len + 1)/2 )
        {
            return "";
        }
        char[] arr = new char[len];
        int evenIdx = 0, oddIdx = 1;
        int halfLen = len / 2;
        for (int i = 0; i < 26; i++)
        {
            char c = (char)('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLen && oddIdx < len)
            {
                arr[oddIdx] = c;
                counts[i]--;
                oddIdx += 2;
            }
            while (counts[i] > 0)
            {
                arr[evenIdx] = c;
                evenIdx += 2;
                counts[i]--;
            }
        }
        return new String(arr);
    }
}
