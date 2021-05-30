package String.day03;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-21 12:59
 */
public class exercise14 {
    //横向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++)
        {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0)
            {
                return "";
            }
        }
        return prefix;
    }
    public String longestCommonPrefix(String str1, String str2)
    {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index))
        {
            index++;
        }
        return str1.substring(0, index);
    }

    //纵向扫描
    public String longestCommonPrefix1(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++)
            {
                if ( i == strs[j].length() || strs[j].charAt(i) != c)
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    //分治
    public String longestCommonPrefix2(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        else return longsCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longsCommonPrefix(String[] strs, int start, int end) {
        if (start == end)
        {
            return strs[start];
        }else
        {
            int mid = (end + start)>>1;
            String lcpLeft = longsCommonPrefix(strs, start, mid);
            String lcpRight = longsCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0 ; i < minLength; i++)
        {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i))
            {
                return lcpLeft.substring(0,i);
            }
        }
        return lcpLeft.substring(0,minLength);
    }
    // 二分查找
    public String longestCommonPrefix3(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs)
        {
            minLength = Math.min(str.length(), minLength);
        }
        int low = 0 , high = minLength;
        while ( low < high )
        {
            int mid = (low + high + 1) >> 1;
            if (isCommonPrefix(strs, mid))
            {
                low = mid;
            }else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++)
        {
            String str = strs[i];
            for (int j = 0; j < length; j++)
            {
                if (str.charAt(j) != str0.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }

}
