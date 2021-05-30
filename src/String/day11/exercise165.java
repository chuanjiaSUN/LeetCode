package String.day11;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-30 16:47
 */
public class exercise165 {
    public int compareVersion(String version1, String version2) {
        List<Integer> list1 = getString(version1);
        List<Integer> list2 = getString(version2);
        for (int i = 0; i < list1.size() || i < list2.size(); i++)
        {
            int a = i >= list1.size() ? 0 : list1.get(i);
            int b = i >= list2.size() ? 0 : list2.get(i);
            if (a > b) return 1;
            if (a < b) return -1;
        }
        return 0;
    }

    private List<Integer> getString(String version) {
        StringBuffer sb = new StringBuffer();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < version.length(); i++)
        {
            if (version.charAt(i) != '.')
            {
                sb.append(version.charAt(i));
            }else{
                ans.add(Integer.valueOf(sb.toString()));
                sb.setLength(0);
            }
        }
        ans.add(Integer.valueOf(sb.toString()));
        return ans;
    }

    //法2 双指针
    public int compareVersion1(String version1, String version2)
    {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();

        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < n1 || p2 < n2)
        {
            pair = getNumChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNumChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2)
            {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    private Pair<Integer, Integer> getNumChunk(String version, int n, int p) {
        if (p > n - 1)
        {
            return new Pair<>(0, p);
        }
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.')
        {
            pEnd++;
        }
        if (pEnd != n - 1)
        {
            i = Integer.parseInt(version.substring(p, pEnd));
        }else
        {
            i = Integer.parseInt(version.substring(p, n));
        }
        p = pEnd + 1;
        return new Pair<>(i, p);
    }


    public static void main(String[] args) {
        exercise165 e = new exercise165();
        int i = e.compareVersion("1.01", "1.0.0");
        System.out.println(i);
    }
}
