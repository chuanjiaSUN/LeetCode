package prepareAutumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-10 23:10
 */
public class Pre438 {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if (lenS < lenP){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < lenP; i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)){
            ans.add(0);
        }
        for(int i = 0; i < lenS - lenP; i++){
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + lenP) - 'a'];
            if (Arrays.equals(sCount, pCount)){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
