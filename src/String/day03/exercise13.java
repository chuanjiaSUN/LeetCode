package String.day03;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-21 12:16
 */
public class exercise13 {

    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        int length = s.length();
        int ans = 0;
        for (int i = 0; i < length; i++)
        {
            ans += getValue(s.charAt(i));
        }
        return ans;
    }
    public int getValue(char c)
    {
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default: return 0;
        }
    }

    //法2
    public int romanToInt1(String s)
    {
        int ans = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1 ; i < s.length(); i++)
        {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                ans -= preNum;
            }else{
                ans += preNum;
            }
            preNum = num;
        }
        ans += preNum;
        return ans;
    }
}
