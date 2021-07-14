package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-14 20:54
 */
public class Interview1618 {
    public boolean patternMatching(String pattern, String value) {
        int countA = 0, countB = 0;
        for(char ch : pattern.toCharArray())
        {
            if (ch == 'a')
            {
                countA++;
            }else{
                countB++;
            }
        }
        if (countA < countB)
        {
            int temp = countA;
            countA = countB;
            countB = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++)
            {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0)
        {
            return countB == 0;
        }
        if (pattern.length() == 0)
        {
            return false;
        }

        //枚举 a 长度
        for (int lenA = 0; countA * lenA <= value.length(); lenA++)
        {
            int rest = value.length() - countA * lenA;
            if ((countB == 0 && rest == 0) || (countB != 0 && rest % countB == 0))
            {
                int lenB = (countB == 0 ? 0 : rest / countB);
                int pos = 0;
                boolean correct = true;
                String valueA = "", valueB = "";
                for (char ch : pattern.toCharArray())
                {
                    if (ch == 'a')
                    {
                        String sub = value.substring(pos, pos + lenA);
                        if (valueA.length() == 0)
                        {
                            valueA = sub;
                        }else if (!valueA.equals(sub))
                        {
                            correct = false;
                            break;
                        }
                        pos += lenA;
                    }else{
                        String sub = value.substring(pos, pos + lenB);
                        if (valueB.length() == 0)
                        {
                            valueB = sub;
                        }else if (!valueB.equals(sub))
                        {
                            correct = false;
                            break;
                        }
                        pos += lenB;
                    }
                }
                if (correct && !valueA.equals(valueB))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
