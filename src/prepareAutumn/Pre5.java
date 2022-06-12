package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-12 20:05
 */
public class Pre5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dynamicPlan = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dynamicPlan[i][i] = true;
        }
        char[] charArray = s.toCharArray();

        for(int length = 2; length <= len; length++){
            for (int left = 0; left < len; left++){
                int right = left + length - 1;
                if (right >= len){
                    break;
                }

                if (charArray[left] != charArray[right]){
                    dynamicPlan[left][right] = false;
                }else{
                    if (right - left < 3){
                        dynamicPlan[left][right] = true;
                    }else{
                        dynamicPlan[left][right] = dynamicPlan[left + 1][right - 1];
                    }
                }

                if (dynamicPlan[left][right] && right - left + 1 > maxLen){
                    maxLen = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
