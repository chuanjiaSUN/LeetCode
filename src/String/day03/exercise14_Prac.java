package String.day03;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-21 13:34
 */
public class exercise14_Prac {
    //纵向扫描
    public String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++)
            {
                if ( i == strs[j].length() || c != strs[j].charAt(i))
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    //横向扫描
    public String longestCommonPrefix1(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++)
        {
            prefix = getCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) return "";
        }
        return prefix;
    }

    private String getCommonPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(), str.length());
        for (int i = 0; i < length; i++)
        {
            if (prefix.charAt(i) != str.charAt(i))
            {
                return prefix.substring(0,i);
            }
        }
        return prefix.substring(0,length);
    }

    //分治
    public String longestCommonPrefix2(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        else{
            return getLongsCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    private String getLongsCommonPrefix(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = (start + end ) >> 1;
        String prefixLeft = getLongsCommonPrefix(strs, start, mid);
        String prefixRight = getLongsCommonPrefix(strs, mid + 1, end);
        return CommonPrefix(prefixLeft, prefixRight);
    }

    private String CommonPrefix(String prefixLeft, String prefixRight) {
        int length = Math.min(prefixLeft.length(), prefixRight.length());
        for (int i = 0; i < length; i++)
        {
            if (prefixLeft.charAt(i) != prefixRight.charAt(i))
            {
                return prefixLeft.substring(0,i);
            }
        }
        return prefixLeft.substring(0, length);
    }

    //二分查找
    public String longestCommonPrefix3(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs)
        {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high)
        {
            int mid = ( low + high + 1) >> 1;
            if (isCommonPrefix(strs, mid))
            {
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        int count = strs.length;
        for (int i = 0; i < length; i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++)
            {
                if (strs[j].charAt(i) != c)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
