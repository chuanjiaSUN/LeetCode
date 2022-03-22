package Interview;


import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-20 18:53
 */
public class Main {

    static class Node{
        public long count;
        public int start;
        public int end;



        public Node(long count, int start, int end){
            this.count = count;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "count=" + count +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int v = sc.nextInt();

            List<Node> lands = new ArrayList<>();

            int start = 1, end = 1;
            for (int i = 0; i < n; i++){
                int count = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                Node node = new Node(count, x, y);
                start = Math.min(start, x);
                end = Math.max(end, y);
                lands.add(node);
            }

            Collections.sort(lands, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.start - o2.start;
                }
            });

            long ans = 0;
            for (int i = start; i <= end; i++){
                int temp = v;
                for (int j = 0; j < lands.size(); j++){
                    Node node = lands.get(j);
                    if (temp > 0 && node.count > 0){
                        if (node.start <= i && node.end >= i){
                            if (node.count >= temp){
                                node.count = node.count - temp;
                                ans += temp;
                                temp = 0;
                                lands.set(j, node);
                            }else{
                                ans += node.count;
                                temp -= node.count;
                                node.count = 0;
                                lands.set(j, node);
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
            t--;
        }

    }
}
