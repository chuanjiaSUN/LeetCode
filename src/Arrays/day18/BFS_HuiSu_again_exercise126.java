package Arrays.day18;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-24 15:41
 */
public class BFS_HuiSu_again_exercise126 {

    //法1 求点到点最短路径，一般考虑广度优先算法
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        Map<String,Integer> wordId = new HashMap<>();//建立 word -> id 的映射
        List<String> idWord = new ArrayList<>();//从id->word映射
        ArrayList<Integer>[] edges;//由单词与单词相连的id构成的边

        //初始化 wordId,idWord
        int id=0;
        for(int i=0;i<wordList.size();i++)
        {
            if(!wordId.containsKey(wordList.get(i))){
                wordId.put(wordList.get(i),id++);
                idWord.add(wordList.get(i));
            }
        }
        wordId.put(beginWord,id++);
        idWord.add(beginWord);
        if(!wordId.containsKey(endWord)) return new ArrayList<List<String>>();

        //初始化edges
        edges = new ArrayList[idWord.size()];
        for(int i=0;i<idWord.size();i++)
        {
            edges[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<idWord.size();i++)
        {
            for(int j=i+1;j<idWord.size();j++)
            {
                if(checkTransfer(idWord.get(i),idWord.get(j)))
                {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int destination = wordId.get(endWord);//终点Id
        int Inf = 1 << 20;
        int[] cost = new int[id];
        for(int i=0;i<id;i++)
        {
            cost[i] = Inf;
        }
        List<List<String>> res = new ArrayList<>();//保存每一条路径中的单词

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();//存放遍历过的路径的id
        int beginId = wordId.get(beginWord);
        temp.add(beginId);
        queue.add(temp);
        cost[beginId] = 0;

        //开始广度优先搜索
        while(!queue.isEmpty())
        {
            ArrayList<Integer> now = queue.poll();//当前节点表示遍历过的路径的点
            int last = now.get(now.size() - 1);
            if(last == destination)//到终点了
            {
                List<String> tmp = new ArrayList<>();
                for(int index:now)
                {
                    tmp.add(idWord.get(index));
                }
                res.add(new ArrayList<>(tmp));
            }else{
                ArrayList<Integer> nextPoints = edges[last];//获取与最后一个节点连接的点
                int count = nextPoints.size();
                for(int i=0;i<count;i++)
                {
                    int next = nextPoints.get(i);
                    if(cost[next] >= cost[last] + 1)
                    {
                        cost[next] = cost[last] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(next);
                        queue.add(tmp);//将该路径加入队列
                    }
                }
            }
        }
        return res;
    }

    private boolean checkTransfer(String s, String s1) {
        int length = s.length();
        int differences = 0;
        for(int i=0;i<length && differences<2;i++)
        {
            if(s.charAt(i)!=s1.charAt(i))
            {
                differences++;
            }
        }
        return differences==1;
    }

    //法2 BFS + 回溯
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if(wordSet.size()==0|| !wordSet.contains(endWord)) return res;

        //第1步，广度优先遍历得到后继结点列表successors key:字符串 value：key的后继节点字符串
        Map<String,Set<String>> successors = new HashMap<>();
        boolean found = bfs(beginWord,endWord,wordSet,successors);
        if(!found) return res;

        //第2步，基于Successors,使用回溯算法得到所有的最短路径列表
        Deque<String> path = new ArrayDeque<>();//双向队列，两端既能入队(offer)也能出队(poll)
        path.addLast(beginWord);
        dfs(beginWord,endWord,successors,path,res);//从所有路径中搜索到endWord最短的路径
        return res;
    }



    private boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        //标准写法，记录访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;
        int wordLen = beginWord.length();
        //当前访问过的节点，当前层全部遍历完以后，再添加到总的visited集合里
        Set<String> nextLevelVisited = new HashSet<>();
        while(!queue.isEmpty())//采用队列，搜出所有的路径
        {
            int currentSize = queue.size();//一层一层的搜索
            for(int i=0;i<currentSize;i++)//搜与这一层元素相连的单词
            {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for(int j=0;j<wordLen;j++)
                {
                    char originChar = charArray[i];
                    for(char k ='a';k<='z';k++)
                    {
                        if(charArray[i]==k)continue;

                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if(wordSet.contains(nextWord))
                        {
                            if(!visited.contains(nextWord)){
                                if(nextWord.equals(endWord))
                                {
                                    found = true;
                                }

                                //避免下层元素重复加入队列，
                                if(!nextLevelVisited.contains(nextWord))
                                {
                                    queue.offer(nextWord);
                                    nextLevelVisited.add(nextWord);
                                }
                                //维护Successors定义
                                successors.computeIfAbsent(currentWord, a->new HashSet<>());
                                successors.get(currentWord).add(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            if(found) break;
            visited.addAll(nextLevelVisited);//当前层搜索完了后，再把下一层的元素添加进去
            nextLevelVisited.clear();

        }
        return found;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> successors, Deque<String> path, List<List<String>> res) {
        if(beginWord.equals(endWord))
        {
            res.add(new ArrayList<>(path));
            return;
        }

        if(!successors.containsKey(beginWord))//路径中不含该节点
        {
            return;
        }

        Set<String> successorsWord = successors.get(beginWord);//得到一个节点得后序路径
        for(String nextWord:successorsWord)
        {
            path.addLast(nextWord);
            dfs(nextWord,endWord,successors,path,res);
            path.removeLast();
        }
    }
}
