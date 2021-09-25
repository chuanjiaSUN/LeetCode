package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-25 20:45
 */
public class Exe767 {
    public String reorganizeString(String s) {
        char[] alphabetArr = s.toCharArray();
        int[] alphabetCount = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        int len = alphabetCount.length;
        for (int i = 0; i < len; i++)
        {
            if (alphabetCount[i] > max)
            {
                max = alphabetCount[i];
                alphabet = i;
                if(max > threshold)
                {
                    return "";
                }
            }
        }
        //最多的字符放偶数索引
        char[] res = new char[length];
        int index = 0;
        while (alphabetCount[alphabet]-- > 0)
        {
            res[index] = (char)(alphabet + 'a');
            index += 2;
        }
        //剩下字符放其他位置
        for (int i = 0; i < len; i++)
        {
            while (alphabetCount[i]-- > 0)
            {
                if (index >= res.length)
                {
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }

    public String reorganizeString1(String s)
    {
        if (s.length() < 2)
        {
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 2;
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            int idx = s.charAt(i) - 'a';
            counts[idx]++;
            maxCount = Math.max(maxCount, counts[idx]);
        }
        if (maxCount > ((length + 1 ) >> 1))
        {
            return "";
        }
        char[] reOrganizeArr = new char[length];
        int evenIdx = 0, oddIndex = 1;
        int halfLength = length/2;
        for (int i = 0; i < 26; i++)
        {
            char c = (char)('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length)
            {
                reOrganizeArr[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0)
            {
                reOrganizeArr[evenIdx] = c;
                counts[i]--;
                evenIdx += 2;
            }
        }
        return new String(reOrganizeArr);
    }
}
