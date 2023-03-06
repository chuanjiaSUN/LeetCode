package prepareAutumn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-26 22:16
 */
public class Pre139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        int len = s.length();
        boolean[] memo = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, new HashSet<>());
    }

    private boolean dfs(String s, int start, List<String> wordDict, HashSet<Integer> objects) {
        if (start == s.length()){
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++){
            if (objects.contains(i)){
                continue;
            }
            if (wordDict.contains(s.substring(start, i))){
                if (dfs(s, i, wordDict, objects)){
                    return true;
                }
                objects.add(i);
            }
        }
        return false;
    }
    /**DP*/
    public boolean wordBreak1(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i < len; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
    /**
     * practice
     * */
    public boolean wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> collect = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && collect.contains(s.substring(j, i))){
                    dp[i] = dp[j];
                }
            }
        }
        return dp[len];
    }
}
