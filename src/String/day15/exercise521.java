package String.day15;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-12 11:25
 */
public class exercise521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
