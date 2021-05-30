package String.day10;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-29 15:23
 */
public class exercise126 {
    // BFS建立图， DFS搜索找解
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String str : wordList) dict.add(str);
        if (!dict.contains(endWord)) return ans;
        dict.remove(beginWord);

        //第一步， BFS建图
        //记录扩展的单词是在第几层得到的，用HashMap
        Map<String, Integer> steps = new HashMap<>();
        //记录单词由哪些单词变换而来
        Map<String, List<String>> from = new HashMap<>();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                String currWord = queue.poll();
                char[] chars = currWord.toCharArray();
                //将每一位变为26为英文字母
                for (int j = 0; j < wordLen; j++)
                {
                    char orgin = currWord.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        chars[j] = c;
                        String nextWord = String.valueOf(chars);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord))
                        {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord))
                        {
                            continue;
                        }
                        //如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                        dict.remove(nextWord);
                        //这一层扩展出的单词进队列
                        queue.offer(nextWord);

                        //记录 nextWord 从currWord来
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currWord);
                        //记录nextWord的step
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord))
                        {
                            found = true;
                        }
                    }
                    chars[j] = orgin;
                }
            }
            step++;
            if (found)
            {
                break;
            }
        }
        //第二步： DFS搜索路径.深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
        if (found)
        {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, ans);
        }
        return ans;
    }

    private void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> ans) {
        if (cur.equals(beginWord))
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(cur))
        {
            path.addFirst(precursor);
            dfs(from,path,beginWord, precursor, ans);
            path.removeFirst();
        }
    }
}
