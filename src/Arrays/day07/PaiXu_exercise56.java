package Arrays.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *

 * @create 2021-03-12 10:32
 */
public class PaiXu_exercise56 {

    //对二维数组的每一个一维数组按左端点排升序，然后合并
    public int[][] merge(int[][] intervals) {
       if(intervals.length == 0)
       {
           return new int[0][2];
       }

       //排序后合并
       Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints1, int[] ints2) {
                return ints1[0] - ints2[0];
            }
        });

       //合并，当前数组最左边值小于前一数组最右边时，合并。
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            int Left = intervals[i][0],Right = intervals[i][1];
            if(list.size() == 0 || list.get(list.size()-1)[1]<Left)
            {
                list.add(intervals[i]);
            }else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size()-1)[1],Right);
            }
        }

        return list.toArray(new int[list.size()][]);

    }

}
