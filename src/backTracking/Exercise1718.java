package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-10 20:14
 */
public class Exercise1718 {
    int[] res = null;
    boolean[] flag;
    int[] a;
    public int[] constructDistancedSequence(int n) {
        flag = new boolean[n + 1];
        a = new int[n * 2 - 1];
        dfs(0, n, 0);
        return res;
    }

    private void dfs(int depth, int n, int index) {
        if (res != null) {
            return;
        } else if (depth == n) {
            res = a.clone();
            return;
        }
        for (int i = index; i < a.length; i++) {
            if (a[i] == 0) {
                for (int j = n; j > 0; j--) {
                    if (!flag[j]) {
                        if (j == 1) {
                            flag[j] = true;
                            a[i] = 1;
                            dfs(depth + 1, n, index + 1);
                            a[i] = 0;
                            flag[j] = false;
                        } else if (i + j < a.length && a[i + j] == 0) {
                            flag[j] = true;
                            a[i] = j;
                            a[i + j] = j;
                            dfs(depth + 1, n, index + 1);
                            a[i] = 0;
                            a[i + j] = 0;
                            flag[j] = false;
                        }
                    }
                }
                break;
            }
        }
    }
}
