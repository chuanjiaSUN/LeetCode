package Arrays.day28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-05 10:44
 */
public class exercise782 {
    public int movesToChessboard(int[][] board) {
        // 关键点：
        // 1、行交换不影响列之间的相同与否状态（列交换同理），可以分别计算
        // 2、某行（列）0、1的个数是一半（+1）
        // 3、只有两种状态的行（列），且个数是一半（+1）

        int N = board.length;

        //count[code] = v , where code is an integer
        // that represents the row in binary, and v
        // is the number of occurrences of the row
        Map<Integer, Integer> count = new HashMap<>();
        for(int[] row : board)
        {
            int code = 0;
            for(int x : row)
            {
                code = 2 * code + x;// code 代表此行的2进制数， 即 *2（左移） + 当前数
            }
            count.put( code, count.getOrDefault(code, 0 ) + 1);
        }

        int k1 = analyzeCount(count, N);//计算交换次数 （其实是使行排列正确， 需要交换行）
        if(k1 == -1) return -1;

        //检查列属性
        count = new HashMap<>();
        for(int c = 0; c < N; c++)
        {
            int code = 0;
            for(int r = 0; r < N; r++)
            {
                code = 2 * code + board[r][c];
            }
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k2 = analyzeCount(count, N);//计算列交换次数
        return k2 >= 0 ? k1 + k2 : -1;
    }

    private int analyzeCount(Map<Integer, Integer> count, int N) {
        //若状态不是两种，肯定不行
        if(count.size() != 2) return -1;

        List<Integer> keys = new ArrayList<>(count.keySet());
        int k1 = keys.get(0), k2 = keys.get(1);// k1, k2就是code二进制数

        //两种状态的列（行）都不是一半(或+1)
        if(!(count.get(k1) == N/2 && count.get(k2) == (N + 1)/2) && !(count.get(k2) == N/2 && count.get(k1) == (N+1)/2))
        {
            return -1;
        }

        //两种不相反，错误
        //使用异或，和N位1比较
        if((k1 ^ k2) != (1<<N)-1)
        {
            return -1;
        }

        int Nones = (1<<N) - 1;//N位1:00..0011..111,后面 & Nones是为了截断前面多余的位数
        int ones = Integer.bitCount(k1 & Nones);//bitCount统计状态1的二进制中1的个数
        int cand = Integer.MAX_VALUE;
        //以下两种情况都要计算一次，要使行中的数字相邻之间不同，需要交换列
        //N是偶数，或者奇数且1的个数小于N，那么就是0开头的状态(AAAA截N位，刚好首尾是0)
        if(N%2 == 0 || ones * 2 < N)// 0xAAAAAAAA：10101010101010101010101010101010
        {
            //找到与正确的1010.。。。相差的位数，则需要交换的次数是一半
            cand = Math.min(cand, Integer.bitCount( k1 ^ 0xAAAAAAAA & Nones) / 2);
        }
        //N是偶数，或者奇数且1的个数大于N，那么就是1开头的状态
        if(N%2 == 0 || ones * 2 > N) // 0x55555555：01010101010101010101010101010101
        {
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);
        }
        return cand;
    }

    //法2
    public int movesToChessboard1(int[][] board)
    {
        //检测是否可以变成棋盘
        if(check(board))
        {
            //取出第一行和第一列，检测最小交换次数
            int[] row = board[0];
            int[] col = new int[board.length];
            for(int i = 0; i < board.length; i++)
            {
                col[i] = board[i][0];
            }
            return find(row) + find(col);
        }else{
            return -1;
        }
    }

    //检测数据需要最少多少次交换成为有序
    private int find(int[] temp) {
        //只检测10101010。。。情况的错位数
        int start = 1;
        int error = 0;
        for(int i : temp)
        {
            //统计多少错位
            if( i != start)
            {
                error++;
            }
            start = 1- start;
        }
        //需要交换的次数是错位的一半
        //排列有序有两种可能 ：101010...   / 01010101...
        //两种情况下计算的错位数相加等于行数，所以只需要计算一种
        if( temp.length % 2 == 0)
        {
            //如行数是偶数，排列为10101010... / 01010101 都可能
            //取两种错位最小值
            return Math.min(temp.length - error, error) >> 1;
        }else{
            //如果行数是奇数，其实只可能拍成1种情况，取决于0和1的数量
            //1 比较多，必然只能排成 1010101010...  0比较多只能排成 01010101010...
            //不可能排成的那种情况下计算出来的错位数就是一个奇数，所以可以通过检测错位数是否为奇数来判断采取哪个情况
            if(error %2 == 0)
            {
                return error>>1;
            }else{
                return (temp.length - error)>>1;
            }
        }
    }

    private boolean check(int[][] board) {
        //检测行是否只有2种模式
        //以第一行为基准，检测其余的所有行，要么与第一行相同，要么相反，否则不行
        int[] first = board[0];
        int cntSame = 1;
        int cntOpposite = 0;
        for(int i = 1; i < board.length; i++)
        {
            if(isSame(first, board[i]))
            {
                cntSame++;
            }else if(isOpposite(first, board[i])){
                cntOpposite++;
            }else{
                return false;
            }
        }
        //检测2种模式的数量分步是否正确
        if(cntSame == cntOpposite || cntSame == cntOpposite + 1 || cntSame == cntOpposite - 1)
        {
            //行只有2种模式，且分步正确，进行列检测
            //行只有2种模式的情况下，列必然也只有2种模式，只检测列的两种模式数量分步是否正确，只用第一个数字代表不同的两种模式进行计数
            int cnt0 = 0;
            int cnt1 = 0;
            for(int i : first)
            {
                if( i == 0)
                {
                    cnt0++;
                }else{
                    cnt1++;
                }
            }
            //检测第一行中0和1的数量（代表两种模式）是否分布正确
            if(cnt0 == cnt1 || cnt0 == cnt1 + 1 || cnt0 == cnt1 - 1)
            {
                return true;
            }else{
                return false;
            }
        }else return false;
    }

    //比较两个数组是否相反
    private boolean isOpposite(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++)
        {
            if( a[i] + b[i] != 1)return false;
        }
        return true;
    }

    //比较两个数组是否相同
    private boolean isSame(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++)
        {
            if( a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }

}
