package Arrays.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]

 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]

 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]

 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *

 * @create 2021-03-12 11:23
 */
public class PaiXu_exercise57 {

    //此方法BUG多
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
        {
            int[][] answer = {{newInterval[0],newInterval[1]}};
            return answer;
        }


        int target = newInterval[0];
        int length = intervals.length;
        int position = findInsert(intervals,target);
        int count = 0;
        List<int[]> list = new ArrayList<>();

        if(position == 0 && newInterval[0]>intervals[0][0])
        {
            list.add(intervals[0]);
        }
        if(position == 0 && newInterval[0]<=intervals[0][0])
        {
            list.add(newInterval);
        }
        for(int i=0;i<position;i++)
        {
            list.add(intervals[i]);
        }

        count = position;
        //插入
        if(list.get(list.size()-1)[1]<newInterval[0])
        {
            list.add(newInterval);
            count++;
        }else{
            list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],newInterval[1]);
        }
        //合并
        for(int i =position;i<length;i++)
        {
            int left = intervals[i][0],right = intervals[i][1];
            if(list.get(list.size()-1)[1]<left)
            {
                list.add(intervals[i]);
                count++;
            }else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],right);
            }
        }

        return list.toArray(new int[count][]);
    }



    private int findInsert(int[][] intervals, int target) {
        int low = 0,high = intervals.length - 1;
        int mid;
        while(low<high)
        {
            mid = (low +high)/2;
            if(intervals[mid][0]<target)
            {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    // 法1 ，模拟
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        int length = intervals.length;
        boolean add = false;
        for (int i = 0; i < length; i++)
        {
            if (intervals[i][1] < left)
            {
                list.add(intervals[i]);//区间在插入区间左侧，直接加入集合
            } else if (intervals[i][0] > right)//区间在右侧，无重合
            {
                if (!add) //没插先插
                {
                    list.add(new int[]{left, right});
                    add = true;
                }
                list.add(intervals[i]);
            } else //其他情况有交集
            {
                    left = Math.min(intervals[i][0], left);
                    right = Math.max(intervals[i][1], right);
            }

        }
        if(!add)
        {
            list.add(new int[]{left, right});
        }
        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        PaiXu_exercise57 p = new PaiXu_exercise57();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[][] intervals = {{1,5}};
        int[] nums = {4,8};
        int[][] insert = p.insert1(intervals, nums);
        for(int[] i:insert)
        {
            for (int x:i)
            {
                System.out.println(x);
            }
        }
    }
}
