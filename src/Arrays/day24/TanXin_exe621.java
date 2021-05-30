package Arrays.day24;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-30 13:32
 */
public class TanXin_exe621 {
    //桶思想
    public int leastInterval(char[] tasks, int n)
    {
        int[] temp = new int[26];
        int maxTask = 0;
        int maxTaskCount = 0;
        for(int i = 0; i < tasks.length; i++)
        {
            int i1 = tasks[i] - 'A';
            temp[i1]++;
            if(temp[i1] > maxTask)
            {
                maxTask = temp[i1];
            }
        }
        for(int i=0;i<26;i++)
        {
            if(temp[i] == maxTask)
            {
                maxTaskCount++;
            }
        }
        return Math.max((maxTask - 1)*(n+1)+maxTaskCount,tasks.length);

    }
}
