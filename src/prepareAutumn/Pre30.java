package prepareAutumn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-31 17:47
 */
public class Pre30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = words[0].length();
        int lenS = s.length();
        int m = words.length;
        for (int i = 0; i < n; i++){
            if (i + m * n > lenS){
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++){
                String word = s.substring(i + j * n, i +  (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words){
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0){
                    differ.remove(word);
                }
            }
            for (int start = i; start < lenS - m * n + 1; start += n){
                if (start != i){
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0){
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0){
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()){
                    ans.add(start);
                }
            }
        }
        return ans;
    }
}
