package prepareAutumn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-16 22:04
 */
public class Pre49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] arr = str.toCharArray();
            int[] counts = new int[26];
            for (char ch : arr){
                counts[ch - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++){
                if (counts[i] != 0){
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<String>());
            list.add(str);
            map.put(sb.toString(), list);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    /**
     * practice
     * */

    // TODO
    public List<List<String>> groupAnagrams1(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            List<List<String>> ans = new ArrayList<>();
            for (String str : strs){
                char[] arr = str.toCharArray();
                int[] nums = new int[26];
                for (char ch : arr){
                    nums[ch - '0']++;
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++){
                    if (nums[i] != 0){
                        sb.append((char)('a' + i));
                        sb.append(nums[i]);
                    }
                }
                String word = sb.toString();
                List<String> list = map.getOrDefault(word, new ArrayList<String>());
                list.add(str);
                map.put(word, list);
            }
            return new ArrayList<>(map.values());
    }
}
