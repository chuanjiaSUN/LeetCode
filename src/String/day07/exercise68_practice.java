package String.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 13:27
 */
public class exercise68_practice {
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0; int j = 0; int blank = 0;
        int rest, wordCount;//定义剩余长度，已用单词个数
        while ( i < n)
        {
            rest = maxWidth;
            wordCount = 0;
            blank = 0;
            while ( j < n && words[j].length() <= rest)
            {
                rest -= words[j++].length();//剩余空间
                wordCount++;
                rest -= 1;//每个单词后要跟一个空格
                blank++;
            }
            blank += rest;
            StringBuffer sb = new StringBuffer();
            if ( j >= n)
            {//特殊情况， 到最后一行后
                while ( i < j)
                {
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth)
                {
                    sb.append(" ");
                }
            }else if (wordCount == 1)
            {
                // 特殊情况 只能装 1个单词
                while ( i < j)
                {
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth)
                {
                    sb.append(" ");
                }
            }else{
                //普通情况
                int mod = blank % (wordCount - 1);
                int mean = blank / (wordCount - 1);//单词之间的平均空格
                while ( i < j)
                {
                    sb.append(words[i++]);
                    int k = mean + (mod > 0 ? 1 : 0);
                    mod--;
                    if (i < j) for (int l = 0; l < k; l++) sb.append(" ");
                }
            }
            i = j;
            ans.add(sb.toString());
        }
        return ans;
    }
}
