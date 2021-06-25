package backTracking;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-25 12:09
 */
public class Exercise131 {
    List<List<String>> ans;
    /**
     * stack 数据结构 建议使用 Deque作为泛型，ArrayDeque作为实现
     * */
    Deque<String> stack;
    public List<List<String>> partition(String s) {
      int len = s.length();
      ans = new ArrayList<>();
      if (len == 0)
      {
          return ans;
      }
      stack = new ArrayDeque<>();
      char[] charArray = s.toCharArray();
      backTrack(charArray, 0, len);
      return ans;
    }

    private void backTrack(char[] charArray, int index, int len) {
        if (index == len)
        {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < len; i++)
        {
            if (!checkPalindrome(charArray, index, i))
            {
                continue;
            }
            stack.addLast(new String(charArray, index, i + 1 - index));
            backTrack(charArray, i + 1, len);
            stack.removeLast();
        }
    }

    private boolean checkPalindrome(char[] charArray, int index, int end) {
        while (index < end)
        {
            if (charArray[index] != charArray[end])
            {
                return false;
            }
            index++;
            end--;
        }
        return true;
    }

    /**
     * 法2 自己写的 优化
     * */
    List<String> path;
    public List<List<String>> partition1(String s)
    {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int len = s.length();
        if (len == 0)
        {
            return ans;
        }
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len);
        return ans;
    }

    private void dfs(char[] charArray, int start, int len) {
        if (start == len)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        //从某一个地方切开
        for (int i = start; i < len; i++)
        {
            if (!checkSucess(charArray, start, i))
            {
                continue;
            }
            path.add(new String(charArray, start, i));
            dfs(charArray, i + 1, len);
            path.remove(path.size() - 1);
        }
    }

    private boolean checkSucess(char[] charArray, int start, int right) {
        while (start < right)
        {
            if (charArray[start] != charArray[right])
            {
                return false;
            }
            start++;
            right--;
        }
        return true;
    }

    /**
     * 法3 使用动态规划优化  --->>> 记忆化搜索
     * */
    boolean[][] f;
    int n;
    public List<List<String>> partition2(String s)
    {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(f[i], true);
        }

        //预处理取得S的回文串动态数组
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = i + 1; j < n; j++)
            {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs1(s, 0);
        return ans;
    }

    private void dfs1(String s, int i) {
        if (i == n)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int start = i; start < s.length(); start++)
        {
            if (f[i][start])
            {
                path.add(s.substring(i, start + 1));
                dfs1(s, start + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 法4 记忆化搜索
     * */
    int[][] dp;
    public List<List<String>> partition3(String s)
    {
        this.n = s.length();
        dp = new int[n][n];
        ans = new ArrayList<>();
        path = new ArrayList<>();

        dfs2(s, 0);
        return ans;
    }

    private void dfs2(String s, int i) {
        if (i == n)
        {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int start = i; start < n; start++)
        {
            if (isPalindrome(s, i, start) == 1)
            {
                path.add(s.substring(i, start + 1));
                dfs2(s, start + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 记忆化搜索
     * @return int 0表示未搜索， 1表示回文 -1表示非回文
     * */
    private int isPalindrome(String s, int i, int j) {
        if (dp[i][j] != 0)
        {
            return dp[i][j];
        }
        if (i >= j)
        {
            dp[i][j] = 1;
        }else if (s.charAt(i) == s.charAt(j))
        {
            dp[i][j] = isPalindrome(s, i + 1, j - 1);
        }else
        {
            dp[i][j] = -1;
        }
        return dp[i][j];
    }
}
