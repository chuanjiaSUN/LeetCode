package num100;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-01 15:03
 */
public class Mian6 {

    public static int[] level;
    public static List<Integer>[] lists;
    public static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        level = new int[n];
        lists = new ArrayList[n];

        for (int i = 0; i < n; i++){
            level[i] = sc.nextInt();
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            lists[x].add(y);
            lists[y].add(x);
        }

        for (int i = 0; i < n; i++){
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] vis = new boolean[n];
            queue.offer(i);
            vis[i] = true;

            int len = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                int flag = 0;
                for (int j = 0; j < size; j++){
                    int temp = queue.poll();
                    if (temp != i && level[temp] == level[i]){
                        res = Math.min(res, len);
                        flag = 1;
                        break;
                    }
                    for (int x : lists[temp]){
                        if (!vis[x]){
                            queue.offer(x);
                            vis[x] = true;
                        }
                    }
                }
                if (flag == 1){
                    break;
                }
                len++;
            }
        }
        if (res == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        System.out.println(res);
    }
}
