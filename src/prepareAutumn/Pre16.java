package prepareAutumn;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-26 23:49
 */
public class Pre16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int best = 10000;
        for (int i = 0; i < len - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k){
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == target){
                    return target;
                }
                if (Math.abs(temp - target) < Math.abs(best - target)){
                    best = temp;
                }
                if (temp > target){
                    int tempK = k - 1;
                    while (tempK > j && nums[tempK] == nums[k]){
                        --tempK;
                    }
                    k = tempK;
                }else{
                    int tempJ = j + 1;
                    while (tempJ < k && nums[tempJ] == nums[j]){
                        ++tempJ;
                    }
                    j = tempJ;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Pre16 pre16 = new Pre16();
        int[] nums = new int[]{-13,592,-501,770,-952,-675,322,-829,-246,657,608,485,-112,967,-30,182,-969,559,-286,-64,24,365,-158,701,535,-429,-217,28,948,-114,-536,-711,693,23,-958,-283,-700,-672,311,314,-712,-594,-351,658,747,949,70,888,166,495,244,-380,-654,454,-281,-811,-168,-839,-106,877,-216,523,-234,-8,289,-175,920,-237,-791,-976,-509,-4,-3,298,-190,194,-328,265,150,210,285,-176,-646,-465,-97,-107,668,892,612,-54,-272,-910,557,-212,-930,-198,38,-365,-729,-410,932,4,-565,-329,-456,224,443,-529,-428,-294,191,229,112,-867,-163,-979,236,-227,-388,-209,984,188,-549,970,951,-119,-146,801,-554,564,-769,334,-819,-356,-724,-219,527,-405,-27,-759,722,-774,758,394,146,517,870,-208,742,-782,336,-364,-558,-417,663,-914,536,293,-818,847,-322,408,876,-823,827,167};
        int i = pre16.threeSumClosest(nums, 7175);
        System.out.println(i);
    }
}
