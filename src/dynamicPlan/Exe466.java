package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-19 11:44
 */
public class Exe466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int index2 = 0;
        int loopTimesOnS2 = 0;

        for (int i = 0; i < n1; i++)
        {
            for (int index1 = 0; index1 < len1; index1++)
            {
                if (arr1[index1] == arr2[index2])
                {
                    index2++;
                }
                if (index2 == len2)
                {
                    loopTimesOnS2++;
                    index2 = 0;
                }
            }
        }
        return loopTimesOnS2 / n2;
    }
    /**动规*/
    public int getMaxRepetitions1(String s1, int n1, String s2, int n2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0 || n1 == 0 || n2 == 0)
        {
            return 0;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int index2 = 0;
        int loopTimeOnS2 = 0;

        //s1循环i次后，s2循环了几次
        int[] times = new int[n1];
        //s1循环了i次后，s2下一个字符匹配的下标
        int[] next = new int[n1];

        for (int i = 0; i < n1; i++)
        {
            for (int index1 = 0; index1 < len1; index1++)
            {
                if (arr1[index1] == arr2[index2])
                {
                    index2++;
                }
                if (index2 == len2)
                {
                    index2 = 0;
                    loopTimeOnS2++;
                }
            }
            times[i] = loopTimeOnS2;
            next[i] = index2;

            if (i > 0 && index2 == next[0])
            {
                //说明出现了循环节
                int headCount = times[0];
                int circulateCount = ((n1 - 1) / i) * (times[i] - times[0]);
                int endCount = times[(n1 - 1) % i] - times[0];
                return (headCount + circulateCount + endCount) / n2;
            }
        }
        return times[n1 - 1] / n2;
    }

}
