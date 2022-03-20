package Interview;


import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-20 15:20
 */
public class T2 {

    private static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[] d = new Node[n];
        Node[] p = new Node[m];
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node node = new Node(x, y);
            d[i] = node;
        }
        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node node = new Node(x, y);
            p[i] = node;

        }
        if (n < m){
            System.out.println(-1);
            return;
        }

        Arrays.sort(d, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        Arrays.sort(p, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.y - o2.y;
            }
        });

        int ans = 0;
        List<Integer> set = new ArrayList<>();

        for (int i = n - 1, j = m - 1; j >= 0;){
            while (i>=0 && d[i].x >= p[j].y){
                set.add(d[i].y);
                i--;
            }
            if (set.isEmpty()){
                System.out.println(-1);
                return;
            }

            Collections.sort(set);
            System.out.println(set);
            int index = find(set, p[j].x);
            if (index == -1){
                set.remove(0);
            }else{
                ans++;
                set.remove(index);
            }
            j--;
        }
        System.out.println(ans);
    }

    private static int find(List<Integer> set, int x) {
        for (int i = 0; i < set.size(); i++){
            if (set.get(i) > x){
                return i;
            }
        }
        return -1;
    }
}
