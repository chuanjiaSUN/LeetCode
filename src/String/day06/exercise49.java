package String.day06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-24 10:53
 */
public class exercise49 {
    //哈希表
    //法1 排序
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String,List<String>>();
        for (String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //法2 计数  每个字母异位的长度相同，字母次数相同。因此可以记录字母次数，并将字母与次数组合作为map的键
    public List<List<String>> groupAnagrams1(String[] strs)
    {
            Map<String,List<String>> map = new HashMap<>();
            for (String str:strs)
            {
                int[] counts = new int[26];
                int length = str.length();
                for (int i = 0; i < length; i++)
                {
                    counts[str.charAt(i) - 'a']++;
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++)
                {
                    //将字母与次数的组合作为map的键
                    if (counts[i] > 0)
                    {
                        sb.append((char)('a' + i));
                        sb.append(counts[i]);
                    }
                }
                String key = sb.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
    }
    //法3
    public List<List<String>> groupAnagrams2(String[] strs)
    {
        //str -> inStream -> sort -> collect by StringBuilder

        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> str
                        .chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()))
                .values());



    }
    public List<List<String>> groupAnagrams3(String[] strs)
    {
        return new ArrayList<>(Arrays.
                stream(strs).
                collect(Collectors.groupingBy(str -> str.
                                chars().
                                sorted().
                                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                                toString())).
                values());
    }
}
