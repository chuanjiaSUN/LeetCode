package Arrays.day13;

import jdk.nashorn.internal.scripts.JO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *

 * @create 2021-03-19 13:01
 */
public class exercise120 {
    //动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
       int high = triangle.size();
       int[][] f = new int[high][high];
       f[0][0] = triangle.get(0).get(0);
       for(int i=1;i<high;i++)
       {
           f[i][0] = f[i-1][0] + triangle.get(i).get(0);//最左边只有一个值
           for(int j=1;j<i;j++)
           {
               f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
           }
           f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);//最右边也只有一个值
       }
       int min = f[high-1][0];
       for(int i=1;i<high;i++)
       {
           min = Math.min(min,f[high-1][i]);
       }
       return min;
    }

    //优化 2个一维数组存储路径和
    public int minimumTotal1(List<List<Integer>> triangle){
        int high = triangle.size();
        int[][] f = new int[2][high];//用两行数组存储路径和，分奇偶行
        f[0][0] = triangle.get(0).get(0);
        for(int i=1;i<high;i++)
        {
            int cur = i % 2;//当前行
            int prey = 1 - cur;//上一行
            f[cur][0] = f[prey][0] + triangle.get(0).get(0);
            for(int j=1;j<i;j++)
            {
                f[cur][j] = Math.min(f[prey][j],f[prey][j-1]) + triangle.get(i).get(j);
            }
            f[cur][i] = f[prey][i-1] + triangle.get(i).get(i);
        }
        int minVal = f[(high-1)%2][0];
        for(int i=1;i<high;i++)
        {
            minVal = Math.min(minVal,f[(high-1)%2][i]);
        }
        return minVal;

    }

    //优化2 用一个数组存储路径和,递减枚举j
    public int minimumTotal2(List<List<Integer>> triangle){
        int high = triangle.size();
        int[] f = new int[high];
        f[0] = triangle.get(0).get(0);
        for(int i=1;i<high;i++) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for(int j = i - 1; j > 0; j--){//递减枚举J,是因为不会改变前面j的数值，如果递增枚举，后面的f[j]会受前面已经变过的f[j]的影响
               f[j] = Math.min(f[j],f[j-1]) + triangle.get(i).get(j);
            }
            f[0] = f[0] + triangle.get(i).get(0);
        }
        int minTruth = f[0];
        for(int i=1;i<high;i++)
        {
            minTruth = Math.min(minTruth,f[i]);
        }
        return minTruth;
    }
}
