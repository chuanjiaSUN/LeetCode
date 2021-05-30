package String.day15;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-13 10:23
 */
public class exercise551 {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int aCount = 0, lCount = 0;
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == 'A') aCount++;
            if (chars[i] == 'L')
            {
                lCount++;
                while (i + 1 < chars.length && chars[i + 1] == 'L')
                {
                    lCount++;
                    i++;
                    if (lCount > 2) return false;
                }
                lCount = 0;
            }
            if (aCount > 1) return false;
        }
        return true;
    }
}
