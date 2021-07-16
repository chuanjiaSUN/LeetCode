package backTracking;


import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-15 20:39
 */
public class SwordOffer38 {
    List<String> combine;
    boolean[] used;
    public String[] permutation(String s) {
        combine = new ArrayList<>();
        used = new boolean[s.length()];
        char[] words = s.toCharArray();
        Arrays.sort(words);
        backTrack(words, new StringBuilder(), 0);
        return combine.toArray(new String[0]);
    }

    private void backTrack(char[] array, StringBuilder sb, int index) {
        if (sb.length() == array.length)
        {
            combine.add(sb.toString());
            return;
        }
        if (index >= array.length)
        {
            return;
        }
        for (int i = 0; i < array.length; i++)
        {
            if (i > 0 && array[i] == array[i - 1] && !used[i - 1])
            {
                continue;
            }
            if (!used[i])
            {
                used[i] = true;
                sb.append(array[i]);
                backTrack(array, sb, index);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }

    /**法 2 */
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation1(String s)
    {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int index) {
        if (index == c.length - 1)
        {
            res.add(String.valueOf(c));
            return;
        }
        //记录同一个位置的元素, 防止重复枚举
        Set<Character> set= new HashSet<>();
        for (int i = index; i < c.length; i++)
        {
            if (set.contains(c[i]))
            {
                continue;
            }
            set.add(c[i]);
            swap(i, index);
            dfs(index + 1);
            swap(i, index);
        }
    }

    private void swap(int i, int index) {
        char temp = c[i];
        c[i] = c[index];
        c[index] = temp;
    }
}
