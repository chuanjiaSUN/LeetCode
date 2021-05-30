package Arrays.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *杨辉三角具有以下性质：
 * 依据性质 4，我们可以一行一行地计算杨辉三角。每当我们计算出第 ii 行的值，我们就可以在线性时间复杂度内计算出第 i+1i+1 行的值。

 * @create 2021-03-18 15:52
 */
public class exercise118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                {
                    res.add(1);
                }else{
                    res.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
            }
            ans.add(new ArrayList<>(res));
        }
        return ans;
    }
}
