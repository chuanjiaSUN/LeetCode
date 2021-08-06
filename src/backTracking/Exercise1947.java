package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-31 20:48
 */
public class Exercise1947 {
    int m;
    int n;
    int[][] score;
    boolean[] used;
    int max;
    int cur;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.m = students.length;
        this.n = students[0].length;
        this.score = new int[m][m];
        this.used = new boolean[m];
        this.max = 0;
        this.cur = 0;

        for (int stuudentIndex = 0; stuudentIndex < m; stuudentIndex++)
        {
            for (int mentorIndex = 0; mentorIndex < m; mentorIndex++)
            {
                int curScore = 0;
                for (int nIndex = 0; nIndex < n; nIndex++)
                {
                    if (students[stuudentIndex][nIndex] == mentors[mentorIndex][nIndex])
                    {
                        curScore++;
                    }
                }
                score[stuudentIndex][mentorIndex] = curScore;
            }
        }

        backTrack(0);
        return this.max;
    }

    private void backTrack(int studentIndex) {
        if (studentIndex == m)
        {
            max = Math.max(max, cur);
            return;
        }
        for (int mentorIndex = 0; mentorIndex < m; mentorIndex++)
        {
            if (!used[mentorIndex])
            {
                used[mentorIndex] = true;
                cur += score[studentIndex][mentorIndex];
                backTrack(studentIndex + 1);
                used[mentorIndex] = false;
                cur -= score[studentIndex][mentorIndex];
            }
        }
    }
}
