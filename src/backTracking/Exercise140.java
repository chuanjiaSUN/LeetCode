package backTracking;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-25 13:05
 */
public class Exercise140 {
    /**
     * 记忆化搜索
     * */

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backTrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<>();
        for (List<String> wordBreak : wordBreaks)
        {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    private List<List<String>> backTrack(String s, int length, HashSet<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index))
        {
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length)
            {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++)
            {
                String word = s.substring(index, i);
                if (wordSet.contains(word))
                {
                    List<List<String>> nextWordBreaks = backTrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks)
                    {
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    /**
     * 法2
     * */
    public List<String> wordBreak1(String s, List<String> wordDict)
    {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        //动态规划取得单词任意长度前缀是否可以分割
        for (int right = 1; right <= len; right++)
        {
            //如果单词集合中单词长度不长，从后向前遍历更快
            for (int left = right - 1; left >= 0; left--)
            {
                if (wordSet.contains(s.substring(left, right)) && dp[left])
                {
                    dp[right] = true;
                    break;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        if (dp[len])
        {
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordSet, dp, path, ans);
            return ans;
        }
        return ans;
    }

    /**
     * s[0:len)如果可以拆分，将递归结果加入ans, 从后向前拆分
     * @param s 单词
     * @param len 长为len的单词前缀子串
     * @param wordSet 用来快速判断单词是否在集合
     * @param dp 单词前缀可以拆分的动态数组
     * @param path 叶子节点到根节点路径
     * @param ans 结果
     * */
    private void dfs(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> ans) {
        if (len == 0)
        {
            ans.add(String.join(" ", path));
            return;
        }

        for (int i = len - 1; i >= 0; i--)
        {
            String suffix = s.substring(i, len);
            //如果后缀在单词列表中，并且i索引位置可以拆分
            if (wordSet.contains(suffix) && dp[i])
            {
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, ans);
                path.removeFirst();
            }
        }
    }
}
