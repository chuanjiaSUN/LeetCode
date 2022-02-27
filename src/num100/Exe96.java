package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-24 15:46
 */
public class Exe96 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i < n + 1; i++){
            for (int j = 1; j <= i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
