package String.day10;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-29 16:10
 */
public class exercise126_prac {

    //BFS + DFS +ReCall
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) return ans;

        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);//set存储所有word
        dict.remove(beginWord);

        //1、 BFS建立图
        Map<String, Integer> steps = new HashMap<>();//记录单词的层数
        Map<String, List<String>> from = new HashMap<>();//记录单词由哪些变换而来，即路径

        boolean found = bfs(steps, dict, from, beginWord, endWord);

        //1、BFS搜索路径
        if (found)
        {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);//从最下面开始寻找
            dfs(ans,beginWord, endWord, from, path);
        }
        return ans;
    }

    private void dfs(List<List<String>> ans, String beginWord, String cur, Map<String, List<String>> from, Deque<String> path) {
        if ( cur.equals(beginWord))
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (String preWord : from.get(cur))
        {
            path.addFirst(preWord);
            dfs(ans, beginWord, preWord, from, path);
            path.removeFirst();
        }
    }

    private boolean bfs(Map<String, Integer> steps, Set<String> dict,Map<String, List<String>> from, String beginWord, String endWord) {
        int step = 1;
        int length = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean found = false;
        //使用队列做广度优先遍历，遍历每一个单词的下一个节点
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)//走完这个循环就是一层
            {
                String currWord = queue.poll();
                char[] chars = currWord.toCharArray();
                for (int j = 0; j < length; j++)
                {
                    char orign = chars[j];
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        chars[j] = c;
                        String nextWord = String.valueOf(chars);
                        //如果遍历过这个单词，且层数一样，就需要把它加到路径中去 (是寻找所有路径)
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step)
                        {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord))
                        {
                            continue;//wordList不存在该单词
                        }
                        dict.remove(nextWord);//使下一层的单词不包含它，因为下面几层的遍历到达距离更远
                        queue.offer(nextWord);

                        //更新from
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currWord);

                        //更新steps
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) found = true;
                    }
                    chars[j] = orign;//将单词换回原来的
                }
            }
            step++;
            if (found) break;
        }
        return found;
    }

    public static void main(String[] args) {
        exercise126_prac e = new exercise126_prac();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("hot");
        objects.add("dot");
        objects.add("dog");
        objects.add("lot");
        objects.add("log");
        objects.add("cog");
        List<List<String>> ladders = e.findLadders("hit", "cog", objects);
        for (List<String> list : ladders)
        {
            System.out.println(list);
        }
    }
}
