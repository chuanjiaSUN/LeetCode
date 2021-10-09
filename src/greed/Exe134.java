package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-09 11:44
 */
public class Exe134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumGas = 0, sumCost = 0;
            int cnt = 0;
            while (cnt < n)
            {
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas)
                {
                    break;
                }
                cnt++;
            }
            if (cnt == n)
            {
                return i;
            }else{
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
