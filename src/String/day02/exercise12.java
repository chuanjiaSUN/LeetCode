package String.day02;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-20 11:24
 */
public class exercise12 {
    //贪心
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++)
        {
            while (values[i] <= num)
            {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
    //硬编码
    public String intToRoman1(int num)
    {
        String[] thousands = {"","M","MM","MMM"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] ones  = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return thousands[num/1000] + hundreds[num%1000/100] + tens[num%100/10] + ones[num%10];
    }
}
