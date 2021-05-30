package Arrays.day03;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @create 2021-03-08 14:54
 */
public class erercise151 {

    //法1 调API
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);

    }

    //法2
    public String reverseWords1(String s){
        StringBuilder sb = trimSpace(s);
        int right = sb.length();
        reservse(sb,0,right-1);
        reservseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder trimSpace(String s){
        int left = 0, right = s.length() - 1;
        //去掉字符串开头空白
        while(left<=right && s.charAt(left) == ' '){
            ++left;
        }
        //去掉字符串结尾空格
        while(right>=left && s.charAt(right) == ' '){
            --right;
        }
        //将字符串间多余空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);

            if(c != ' '){
                sb.append(c);
            }else if(sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    public void reservse(StringBuilder sb,int left,int right){
        while(left<right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }

    public void reservseEachWord(StringBuilder sb){
        int length = sb.length();
        int start = 0, end = 0;

        while(start<length){
            //循环到单词末尾
            while(end<length && sb.charAt(end) != ' '){
                ++end;
            }
            //翻转单词
            reservse(sb,start,end-1);
            start = end + 1; //找下一个单词
            ++end;
        }

    }

    //法3 双端队列
    /*
    由于双端队列支持从队列头部插入的方法，因此我们可以沿着字符串一个一个单词处理，然后将单词压入队列的头部，再将队列转成字符串即可
    * */
    public String reverseWords2(String s){
        int left = 0, right = s.length() - 1;
        //去掉字符串开头和结尾的空白字符
        while(left<=right && s.charAt(left) ==' '){
            left++;
        }
        while(right>=left && s.charAt(right) == ' '){
            right--;
        }

       Deque<String> deque = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while(left <= right)
        {
            char c = s.charAt(left);
            if (word.length() != 0 && (c == ' ')){
                //将单词Push到队列头部
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if( c!= ' '){
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());

        return String.join(" ",deque);
    }



    public static void main(String[] args) {
        erercise151 e = new erercise151();
        String the_sky_is_blue = e.reverseWords("a good   example");
        System.out.println(the_sky_is_blue);
    }

}
