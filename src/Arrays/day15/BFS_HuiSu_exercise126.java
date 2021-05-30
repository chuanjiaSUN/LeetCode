package Arrays.day15;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]

 * @create 2021-03-21 9:36
 */
public class BFS_HuiSu_exercise126 {

    private static final int INF = 1 << 20;
    private Map<String,Integer> wordId = new HashMap<>();//word -->> id映射
    private ArrayList<String> idWord = new ArrayList<>();//id -->>word 映射
    private ArrayList<Integer>[] edges;//图的边


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        //将WordList中所有单词加入WordId,相同的只保留一个
        for(String str:wordList)
        {
            if(!wordId.containsKey(str))
            {
                wordId.put(str,id++);
                idWord.add(str);
            }
        }

        //若endWord不在 wordId中，无解
        if(!wordId.containsKey(endWord)) return new ArrayList<>();

        //beginWord放入wordId中
        if(!wordId.containsKey(beginWord)){
            wordId.put(beginWord,id++);
            idWord.add(beginWord);
        }

        //初始化存边用的数组,并添加边
        edges = new ArrayList[idWord.size()];
        for(int i=0;i<idWord.size();i++)
        {
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<idWord.size();i++)
        {
            for(int j=i+1;j<idWord.size();j++)
            {
                //若两者可以通过转换得到，则在他们之间建一条无向边
                if(transformCheck(idWord.get(i),idWord.get(j))){
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord);//目的id
        List<List<String>> res = new ArrayList<>();//存答案
        int[] cost = new int[id];//到每个点代价
        for(int i=0;i<id;i++)
        {
            cost[i] = INF;//每个点代价初始值为无穷大
        }

        //将起点加入队列
        Queue<ArrayList<Integer>> q = new LinkedList<>();//队列每一个节点中保存从起点开始的所有路径
        ArrayList<Integer> tmpBegin = new ArrayList<>();//存放遍历过的点 构成 的路径
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        //开始广度优先搜索
        while(!q.isEmpty())
        {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1);//最近的访问点
            if(last == dest){//若该最近访问点为终点,则存入答案
                ArrayList<String > tmp = new ArrayList<>();
                for(int index : now)
                {
                    tmp.add(idWord.get(index));//转换为对应的word
                }
                res.add(tmp);
            }else{//该点不为终点
                for(int i=0;i<edges[last].size();i++)
                {
                    int to = edges[last].get(i);//得到与last连接的点

                    // <=是为了将代价相同的不同路径全部保留下来
                    if(cost[last] +1 <= cost[to]){
                        cost[to] = cost[last] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp);//把这个路径加入队列
                    }
                }
            }
        }
        return  res;
    }

    //检查两个字符串是否可以通过改变一个字母后相等
    private boolean transformCheck(String s, String s1) {
        int differences = 0;
        for(int i=0;i<s.length() && differences < 2;i++)
        {
            if(s.charAt(i) != s1.charAt(i))
            {
                differences++;
            }
        }
        return differences == 1;
    }

    //法2 优化,利用回溯的思想，最短路径采用BFS一层一层的找，并记录遍历层数，用DFS遇到遍历过的节点但层数>=时可以直接跳过
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList){
        List<List<String>> ans = new ArrayList<>();
        //如果不含结束单词，直接结束
        if(!wordList.contains(endWord)) return ans;
        //利用BFS得到所有邻居节点，以及每个节点所在层数
        HashMap<String,Integer> distance = new HashMap<>();//每个节点层数,深度
        HashMap<String,ArrayList<String>> map = new HashMap<>();//每个节点的邻居节点
        bfs(beginWord,endWord,wordList,distance,map);
        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);
        findLaddersHelper(beginWord,endWord,map,distance,temp,ans);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance, ArrayList<String> temp, List<List<String>> ans) {
        if(beginWord.equals(endWord)){
            ans.add(new ArrayList<String>(temp));
            return;
        }
        //得到所有的下一个节点
        ArrayList<String> neighbors = map.getOrDefault(beginWord,new ArrayList<String>());
        for(String neighbor:neighbors)
        {
            if(distance.get(beginWord) + 1 == distance.get(neighbor))
            {
                temp.add(neighbor);
                findLaddersHelper(neighbor,endWord,map,distance,temp,ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, Integer> distance, HashMap<String, ArrayList<String>> map) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord,0);
        boolean isFound = false;
        int depth = 0;
        Set<String> dict = new HashSet<>(wordList);//将WordLIsT转为哈希表方便查找
        while(!queue.isEmpty())
        {
            int size = queue.size();
            depth++;
            for(int i=0;i<size;i++)
            {
                String temp = queue.poll();
                //一次性得到所有的下一个节点
                ArrayList<String> neighbors = getNeighbors(temp,dict);
                map.put(temp,neighbors);
                for(String neighbor:neighbors)
                {
                    if(!distance.containsKey(neighbor))
                    {
                        distance.put(neighbor,depth);
                        if(neighbor.equals(endWord))
                        {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }
                }
            }
            if(isFound) break;
        }
    }

    private ArrayList<String> getNeighbors(String temp, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = temp.toCharArray();

        for(char ch='a';ch<='z';ch++)
        {
            for(int i=0;i<chars.length;i++)
            {
                if(chars[i] == ch)
                {
                    continue;
                }
                char old = chars[i];
                chars[i] = ch;
                if(dict.contains(String.valueOf(chars)))
                {
                    res.add(String.valueOf(chars));
                }
                chars[i] = old;
            }
        }
        return res;
    }

}
