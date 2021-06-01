package tree.day19;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-01 10:13
 */
public class exercise685 {
    class UnionFind{
        int[] ancestor;

        public UnionFind(int n)
        {
            ancestor = new int[n];
            for (int i = 0; i < n; i++)
            {
                ancestor[i] = i;
            }
        }
        public void union(int node1, int node2)
        {
            ancestor[find(node1)] = find(node2);
        }

        public int find(int node)
        {
            if (ancestor[node] != node)
            {
                ancestor[node] = find(ancestor[node]);
            }
            return ancestor[node];
        }


    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        UnionFind uf = new UnionFind(nodesCount + 1);
        for (int i = 1; i <= nodesCount; i++)
        {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; i++)
        {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2)
            {
                conflict = i;//记录有两个父节点的边
            }else
            {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2))
                {
                    cycle = i;
                }else
                {
                    uf.union(node1, node2);//合并连通分量
                }
            }
        }
        if (conflict < 0)
        {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        }else
        {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0)
            {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            }else
            {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}
