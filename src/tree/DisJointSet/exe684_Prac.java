package tree.DisJointSet;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-31 19:11
 */
public class exe684_Prac {

    //并查集练习， 并查集主要用来处理数据的连通性问题， 寻根、合并
    public int[] findRedundantConnection(int[][] edges)
    {
        int edgeCount = edges.length;
        int[] parent = new int[edgeCount + 1];
        for (int i = 0; i <= edgeCount; i++)
        {
            parent[i] = i;//将各点的父节点初始化为自己
        }

        //遍历每一条边，判断两个顶点的连通性
        for (int i = 0; i < edgeCount; i++)
        {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2))
            {
                //如果两个点不连通，合并连通分量
                union(parent, node1, node2);
            }else
            {
                //如果已经连通，说明这条边的出现导致成环
                return edge;
            }
        }
        return new int[2];
    }

    private void union(int[] parent, int node1, int node2) {
        int index1 = find(parent, node1);
        int index2 = find(parent, node2);
        parent[index1] = index2; // 这条边，加入并查集， 即合并连通分量
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node)//即父节点不是本身，说明可以往上寻根
        {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
