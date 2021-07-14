package backTracking;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-14 21:37
 */
public class Interview1722 {
    List<String> ans;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        boolean[] visited = new boolean[wordList.size()];
        //存放单词的前驱
        Map<String, String> map = new HashMap<>(1000);
        if (!wordList.contains(endWord))
        {
            return ans;
        }
        queue.add(beginWord);
        boolean flag = false;

        while (!queue.isEmpty())
        {
            String head = queue.poll();
            if (head.equals(endWord))
            {
                flag = true;
                break;
            }
            for (int i = 0; i < wordList.size(); i++)
            {
                if (!visited[i] && compare(wordList.get(i), head))
                {
                    queue.add(wordList.get(i));
                    visited[i] = true;
                    map.put(wordList.get(i), head);
                }
            }
        }
        if (flag = false)
        {
            return ans;
        }

        //遍历答案
        String key = endWord;
        while (!map.get(key).equals(endWord))
        {
            ans.add(key);
            key = map.get(key);
        }
        ans.add(key);
        ans.add(map.get(key));
        Collections.reverse(ans);
        return ans;
    }

    private boolean compare(String src, String dst) {
        int diff = 0;
        for (int i = 0; i < src.length(); i++)
        {
            if (src.charAt(i) != dst.charAt(i))
            {
                diff++;
                if (diff >= 2)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**DFS + 剪枝*/
    List<String> map;
    String ew,bw;
    List<String> result=new ArrayList<>();
    List<String> fake=new ArrayList<>();
    boolean []flag;
    /**定义几个成员变量，方便在其他函数中使用，布尔数组flag用来记录已经查看过的节点*/
    public List<String> findLadders1(String beginWord, String endWord, List<String> wordList) {
        map=wordList;
        ew=endWord;
        bw=beginWord;
        flag=new boolean[wordList.size()];
        dfs(beginWord);
        return result;

    }
    /**dfs用来递归调用，并且返回值为Boolean，当找到正确答案时，就直接可以快速退出所有的dfs
     * 在进入下一层时，将路径记录，如果没有找到答案就返回上一层，并且，并且把路径fake去掉最后一个String*/
    public boolean dfs(String temp) {
        List<String> neighborhood=near(temp);
        if(!neighborhood.isEmpty()) {
            for(String tt:neighborhood) {
                fake.add(tt);
                if(tt.equals(ew)) {
                    result.add(bw);
                    for(String str:fake) {
                        //这一步没有办法直接的将result=fake这么写，
                        //因为这么写的话就会导致result记录的是fake的地址，后面改变fake会改变result的值
                        result.add(str);
                    }
                    return true;
                }
                if(dfs(tt)) {
                    return true;
                }
                else{
                    fake.remove(fake.size()-1);
                }
            }
        }
        else {
            return false;
        }
        return false;

    }
    /**这个函数就是返回一个ArraysList，就是当前的str的所临近（一个字符不同）的所有的字符串，
    并且将返回的字符串标记下，如果标记过的字符串不再返回，至于为啥要这么做，建议拿个草稿纸
    模拟下题目所给的案例，如果没这一步就会需要一直递归，而且浪费时间和资源*/
    public List<String> near(String str){
        List<String> res=new ArrayList<>();
        int len1=str.length();
        for(int j=0;j<map.size();j++) {
            String tt=map.get(j);
            if(tt.length()!=len1||flag[j])
            {
                continue;
            }
            int differ=0;
            for(int i=0;i<len1;i++) {
                if(str.charAt(i)!=tt.charAt(i)){
                    differ++;
                }
                if(differ==2){
                    break;
                }
            }
            if(differ==1) {
                flag[j]=true;
                res.add(tt);
            }
        }
        return res;
    }

}
