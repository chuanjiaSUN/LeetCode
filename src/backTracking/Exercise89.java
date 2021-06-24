package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-24 11:37
 */
public class Exercise89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(){
            {add(0);}
        };
        int head = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = res.size() - 1; j >= 0; j--)
            {
                res.add(head + res.get(j));
            }
            head <<= 1 ;
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        Exercise89 e = new Exercise89();
        e.grayCode(4);
    }

}
