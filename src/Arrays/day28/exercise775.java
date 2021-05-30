package Arrays.day28;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-05 10:21
 */
public class exercise775 {
    //记住最小值
    public boolean isIdealPermutation(int[] A) {
       int length = A.length;
       int floor = length;
       for(int i = length - 1; i>=2; i--)
       {
           floor = Math.min(floor, A[i]);
           if(A[ i - 2] > floor) return false;
       }
       return true;
    }

    //线性搜索
    public boolean isIdealPermutation1(int[] A)
    {
        for(int i = 0; i < A.length; i ++)
        {
            if(Math.abs(A[i] - i) >= 1) return false;
        }
        return true;
    }
}
