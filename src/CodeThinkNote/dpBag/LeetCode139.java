package CodeThinkNote.dpBag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-02 21:08
 */
public class LeetCode139 {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        memo = new int[len + 1];
        for (String str : wordDict){
            set.add(str);
        }
        return dfs(s, wordDict, 0, set, len);
    }

    private boolean dfs(String s, List<String> wordDict, int index, Set<String> set, int len) {
        if (index == len){
            return true;
        }
        if (memo[index] != 0){
            return memo[index] == 1;
        }
        for (int i = index; i < len; i++){
            if (set.contains(s.substring(index, i + 1)) && dfs(s, wordDict, i + 1, set , len)){
                memo[i] = 1;
                return true;
            }
        }
        memo[index] = 2;
        return false;
    }
}
