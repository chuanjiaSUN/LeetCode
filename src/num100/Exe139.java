package num100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-27 13:18
 */
public class Exe139 {

    /**法1 动态规划*/
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    /**法2 回溯*/
    int[] memo;
    public boolean wordBreak1(String s, List<String> wordDict) {
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
