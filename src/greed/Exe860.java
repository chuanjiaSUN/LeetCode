package greed;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-20 14:45
 */
public class Exe860 {
    private static final int MONEY = 5;
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills)
        {
            if (bill == 5)
            {
                five++;
            }else if (bill == 10)
            {
                if (five == 0)
                {
                    return false;
                }
                five--;
                ten++;
            }else{
                if (five > 0 && ten > 0)
                {
                    five--;
                    ten--;
                }else if (five >= 3)
                {
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
