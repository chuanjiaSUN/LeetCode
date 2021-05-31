package tree.day18;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-31 16:29
 */
public class exercise684 {

    //并查集
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 0 ; i <= nodesCount; i++)
        {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++)
        {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2))
            {
                union(parent, node1, node2);
            }else
            {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index)
        {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
