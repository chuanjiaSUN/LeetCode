package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-25 22:48
 */
public class Pre12 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++){
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value){
                num -= value;
                sb.append(symbol);
            }
            if (num == 0){
                break;
            }
        }
        return sb.toString();
    }
}
