package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-28 13:54
 */
public class Exercise526 {
    int ans;
    boolean[] visited;
    public int countArrangement(int n) {
        backTrack(n, 1);
        visited = new boolean[n + 1];
        return ans;
    }

    private void backTrack(int n, int index) {
        if (index == n)
        {
            ans++;
            return;
        }
        for (int i = 1; i < n; i++)
        {
           if (i % index == 0 && !visited[i])
           {
               visited[i] = true;
               backTrack(n, index + 1);
                visited[i] = false;
           }
            if (index % i == 0 && !visited[i])
            {
                visited[i] = true;
                backTrack(n, index + 1);
                visited[i] = false;
            }
        }
    }
}
