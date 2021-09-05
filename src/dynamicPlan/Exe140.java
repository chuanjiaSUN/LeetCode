package dynamicPlan;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-05 11:30
 */
public class Exe140 {
    /**法1 回溯*/
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        StringBuffer sb = new StringBuffer();
        Set<String> set = new HashSet<>(wordDict);
        dfs(s, 0, length, set, sb);
        return ans;
    }

    private void dfs(String s, int index, int length, Set<String> wordDict, StringBuffer sb) {
        if (index == length)
        {
            StringBuffer temp = new StringBuffer(sb);
            temp.deleteCharAt(temp.length() - 1);
            ans.add(temp.toString());
            return;
        }
        for (int i = index; i <= length; i++)
        {
            String word = s.substring(index, i);
            if (wordDict.contains(word))
            {
                sb.append(word);
                sb.append(" ");
                int deleteLen = word.length() + 1;
                dfs(s, i, length, wordDict, sb);
                sb.delete(sb.length() - deleteLen, sb.length() + 1);
            }
        }
    }
    /**法2 动态规划*/
    public List<String> wordBreak1(String s, List<String> wordDict)
    {
        int len = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int right = 1; right <= len; right++)
        {
            for (int left = right - 1; left >= 0; left--)
            {
                if (dict.contains(s.substring(left, right)) && dp[left])
                {
                    dp[right] = true;
                    break;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        if (dp[len])
        {
            Deque<String> path = new LinkedList<>();
            dfs1(s, len, dict, dp, path, ans);
            return ans;
        }
        return ans;
    }

    private void dfs1(String s, int len, Set<String> dict, boolean[] dp, Deque<String> path, List<String> ans) {
        if (len == 0)
        {
            ans.add(String.join(" ", path));
            return;
        }
        for (int i = len - 1; i >= 0; i--)
        {
            String suffix = s.substring(i, len);
            if (dict.contains(suffix) && dp[i])
            {
                path.addFirst(suffix);
                dfs1(s, i, dict, dp, path, ans);
                path.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        Exe140 exe140 = new Exe140();
        List<String> list = exe140.wordBreak(s, wordDict);
        System.out.println(list);
    }

}
