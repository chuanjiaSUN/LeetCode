package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-11 22:25
 */
public class Pre461 {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 8; i++){
            int temp1 = x & 1;
            int temp2 = y & 1;
            if (temp1 != temp2){
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
