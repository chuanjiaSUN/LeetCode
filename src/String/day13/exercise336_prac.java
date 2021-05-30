package String.day13;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-10 15:50
 */
public class exercise336_prac {
    //使用哈希表
    List<String> wordVec = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words)
    {
        int n = words.length;
        for (int i = 0; i < n; i++)
        {
            wordVec.add(new StringBuffer(words[i]).reverse().toString());
        }
        for (int i = 0; i < n; i++)
        {
            map.put(wordVec.get(i), i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        //遍历每一个字符串的前缀和后缀,寻找符合要求的字符串，组成回文对
        for (int i = 0; i < n; i++)
        {
            String word = words[i];
            int len = word.length();
            if (len == 0) continue;
            for (int j = 0; j < len; j++)
            {
                if (isPalin(word, j, len - 1))
                {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i)
                    {
                        ans.add(Arrays.asList(i, leftId));
                    }
                }
                if (isPalin(word, 0, j - 1))
                {
                    int rightId = findWord(word, j, len - 1);
                    if (rightId != -1 && rightId != i)
                    {
                        ans.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ans;
    }

    private int findWord(String word, int left, int right) {
        return map.getOrDefault(word.substring(left, right + 1), -1);
    }

    private boolean isPalin(String word, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++)
        {
            if (word.charAt(left + i) != word.charAt(right - i)) return false;
        }
        return true;
    }
}
