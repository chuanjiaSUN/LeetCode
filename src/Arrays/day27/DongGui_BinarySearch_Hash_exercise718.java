package Arrays.day27;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。

 * @create 2021-04-02 10:59
 */
public class DongGui_BinarySearch_Hash_exercise718 {

    // 法1 动态规划
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for( int i = n - 1; i >= 0; i--)
        {
            for(int j = m - 1; j >= 0; j--)
            {
                dp[i][j] = A[i]==B[j] ? dp[i + 1][j + 1] + 1:0;
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    //法2 滑动窗口
    public int findLength1(int[] A, int[] B){
        int n = A.length, m = B.length;
        int ret = 0;
        for(int i = 0; i < n; i++)
        {
            int len = Math.min(m ,n - i);
            int maxLen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxLen);
        }
        for(int i = 0; i < m; i++)
        {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(A, B,0, i, len);
            ret = Math.max(ret, maxLen);
        }
        return ret;
    }

    //addA addB表示滑动窗口对齐的起点
    private int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for( int i = 0; i < len; i++)
        {
            if(A[addA + i] == B[addB + i])
            {
                k++;
            }else{
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    // 二分查找 + 哈希(对子数组序列计算哈希值)
    private int mod = 1000000009;
    private int base = 113;
    public int findLength2(int[] A, int[] B)
    {
        int left = 1, right = Math.min(A.length, B.length) + 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(check(A, B, mid))
            {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left - 1;
    }

    private boolean check(int[] A, int[] B, int len) {
        long hashA = 0;
        for( int i = 0; i < len; i++)
        {
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> bucketA = new HashSet<>();
        bucketA.add(hashA);
        long mult = qPow(base, len-1);
        //计算数组中所有长度为len的序列的哈希
        for( int i = len; i < A.length; i++)
        {
            hashA = ((hashA - A[i - len] * mult % mod +mod) % mod *base + A[i]) % mod;
            bucketA.add(hashA);
        }
        long hashB = 0;
        for( int i = 0; i < len; i++)
        {
            hashB = (hashB * base + B[i]) % mod;
        }
        if(bucketA.contains(hashB))
        {
            return true;
        }
        for( int i = len; i < B.length; i++)
        {
            hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
            if(bucketA.contains(hashB))
            {
                return true;
            }
        }
        return false;
     }

     //快速幂计算， x^n % mod 的值
    private long qPow(long x, long n) {
        long ret = 1;
        while( n != 0)
        {
            if (( n & 1) != 0)
            {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ret;
    }
}
