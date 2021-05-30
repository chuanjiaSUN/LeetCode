package String.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 9:39
 */
public class exercise68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0, j = 0, blank = 0;
        int rest,wordCount;
        while ( i < n )
        {
            rest = maxWidth;
            wordCount = 0;
            blank = 0;
            while ( j < n && rest >= words[j].length())
            {
                rest -= words[j++].length();
                wordCount++;
                rest -= 1;//后面要接单词就需要留一个空格
                blank++;
            }
            blank += rest;
            StringBuilder sb = new StringBuilder();
            //特殊情况，如果是最后一行，单词之间只占一个空格
            if ( j >= n)
            {
                while ( i < j)
                {
                    sb.append(words[ i++ ]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth)
                {
                    sb.append(" ");
                }
            }else if (wordCount == 1)
            {
                //特殊情况2 ，如果一行只有1个单词。补齐右边空格
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
                int mod = blank % ( wordCount - 1);
                int bsn = blank / (wordCount - 1);
                while ( i < j)
                {
                    sb.append(words[i++]);
                    int k = bsn + ( mod > 0 ? 1 : 0);
                    mod--;
                    if ( i < j ) for (int l = 0; l < k; l++) sb.append(" ");
                }
            }
            i = j;
            ans.add(sb.toString());
        }
        return ans;
    }



}
