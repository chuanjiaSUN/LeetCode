package Arrays.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *输入: 3
 * 输出: [1,3,3,1]

 * @create 2021-03-18 16:00
 */
public class exercise119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<rowIndex;i++)
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
        return ans.get(rowIndex-1);
    }

    //使用滚动数组进行优化
    public List<Integer> getRow1(int rowIndex){
        List<Integer> ans =  new ArrayList<>();//滚动数组，每迭代一行，值进行更新，最后返回它
        for(int i=0;i<=rowIndex;i++)
        {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                {
                    res.add(1);
                }else{
                    res.add(ans.get(j)+ans.get(j-1));
                }
            }
            ans = res;
        }
        return ans;
    }
}
