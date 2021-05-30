package String.day05;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-23 10:38
 */
public class SlideWindow_exercise30 {
    //1 截取一定长度字符串比较是否相等
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;

        for (String word : words)
        {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++)
        {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; i < all_len; j += one_word)
            {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    //法2 滑动窗口  法1会反复遍历串S,就可以每次移动一个单词的长度
    public List<Integer> findSubstring1(String s, String[] words)
    {
        if (s == null || s.length() == 0 || words == null || words.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int oneWordLength = words[0].length();
        int wordCount = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
        {
            map.put(word,map.getOrDefault(word, 0) +1);
        }

        //因为是每次移动一个单词长度，就需要维护对应的滑动窗口，而滑动窗口的起始点其实有一个wordLength那么多
        for (int i = 0; i < oneWordLength; i++)
        {
            int left = i, right = i, count = 0;//定义窗口左右边界，单词个数
            Map<String, Integer> temp = new HashMap<>();
            while (right + oneWordLength <= s.length())//扩展窗口边界，加入新的单词
            {
                String str = s.substring(right, right + oneWordLength);
                temp.put(str, temp.getOrDefault(str, 0) + 1);
                count++;
                right += oneWordLength;
                while (temp.getOrDefault(str, 0) > map.getOrDefault(str, 0))//当截取的单词个数超过原有时，需要删去他
                {
                    String tmp = s.substring(left, left + oneWordLength);
                    temp.put(tmp, temp.getOrDefault(tmp, 0) - 1);
                    count--;
                    left += oneWordLength;
                }
                if (count == wordCount) res.add(left);
            }
        }
        return res;
    }

    //法3 滑动窗口优化
    public List<Integer> findSubstring2(String s, String[] words)
    {
        if (s == null || s.length() == 0 || words == null || words.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int oneWordLength = words[0].length();
        int wordCount = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
        {
            map.put(word,map.getOrDefault(word, 0) +1);
        }
        for (int i = 0; i < oneWordLength; i++)
        {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> temp = new HashMap<>();
            while (right + oneWordLength <= s.length())
            {
                String w = s.substring( right, right + oneWordLength);
                right += oneWordLength;
                if (!map.containsKey(w))//剪枝
                {
                    count = 0;
                    left = right;
                    temp.clear();
                }else
                {
                    temp.put(w, temp.getOrDefault(w, 0) +1);
                    count++;
                    while (temp.getOrDefault(w, 0) > map.getOrDefault(w, 0))
                    {
                        String str = s.substring(left, left + oneWordLength);
                        count--;
                        left += oneWordLength;
                        temp.put(str, temp.getOrDefault(str, 0) -1);
                    }
                }
                if ( count == wordCount) res.add(left);
            }
        }
        return res;
    }
    //朴素方法copy
    public List<Integer> findSubstring3(String s, String[] words)
    {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int oneWordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = oneWordLength * wordCount;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
        {
            map.put(word,map.getOrDefault(word, 0) +1);
        }
        for (int i = 0; i < s.length() - totalLength +1; i++)
        {
            String sub = s.substring(i, i + totalLength);
            Map<String, Integer>  temp = new HashMap<>();
            for (int j = 0; j < totalLength; j+= oneWordLength)
            {
                String w = sub.substring(j, j + oneWordLength);
                temp.put(sub, temp.getOrDefault(sub,0) + 1);
            }
            if (temp.equals(map)) res.add(i);
        }
        return res;
    }


}
