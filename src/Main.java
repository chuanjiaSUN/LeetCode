import java.util.*;

class edge {
    int dst, value;
}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<edge>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new LinkedList<>());
        }
        int u, v, p;
        for (int i = 0; i < m; i++) {
            u = in.nextInt();
            v = in.nextInt();
            p = in.nextInt();
            edge e = new edge();
            e.dst = v;
            e.value = p;
            edges.get(u).add(e);
            edge e1 = new edge();
            e1.dst = u;
            e1.value = p;
            edges.get(v).add(e1);
        }
        Set<Integer> set = new HashSet<>();
        PriorityQueue<edge> pq = new PriorityQueue<>(new Comparator<edge>() {
            @Override public int compare(edge o1, edge o2) {
            return o2.value - o1.value;
        }
        });
        set.add(1);
        pq.addAll(edges.get(1));
        int max = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            edge e = pq.poll();
            max = Math.min(max, e.value);
            set.add(e.dst);
            for (edge edge : edges.get(e.dst)) {
                if (!set.contains(edge.dst)) {
                    pq.add(edge);
                }
            }
            if (set.size() == n) {
                break;
            }
        }
        System.out.println(max);
    }
}