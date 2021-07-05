package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-05 20:36
 */
public class CombinationIterator {
    int index = 0;
    List<String> ans;
    StringBuilder sb;
    public CombinationIterator(String characters, int combinationLength) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        backTrack(characters.toCharArray(), combinationLength, 0);
    }

    private void backTrack(char[] charArray, int combinationLength, int index) {
        if (sb.length() == combinationLength)
        {
            ans.add(sb.toString());
            return;
        }
        if (sb.length() < combinationLength && index < charArray.length)
        {
            sb.append(charArray[index]);
            backTrack(charArray, combinationLength, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            backTrack(charArray, combinationLength, index + 1);

        }
    }


    public String next() {
        int temp = index;
        index++;
        return ans.get(temp);
    }

    public boolean hasNext() {
        return index < ans.size();
    }

}
