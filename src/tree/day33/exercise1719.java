package tree.day33;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-15 11:37
 */
public class exercise1719 {
    public int checkWays(int[][] pairs) {
        int max = 0;
        for(int[] pair : pairs)
        {
            max = Math.max(max, Math.max(pair[0], pair[1])); // 求节点最大值
        }
        int[] deg = new int[max + 1];//记录每个节点祖先关系数量
        int[][] conn = new int[max + 1][max + 1];
        for (int[] pair : pairs)
        {
            deg[pair[0]]++;
            deg[pair[1]]++;
            conn[pair[0]][pair[1]] = 1;
            conn[pair[1]][pair[0]] = 1;
        }
        // 建一个新数组， 后面可以按祖先关系数量大小排序
        Integer[] nodes = new Integer[max + 1];
        int n = 0;
        for(int i = 1; i <= max; i++)
        {
            if (deg[i] > 0) nodes[n++] = i;
        }
        Arrays.sort(nodes, 0, n, (a, b) -> deg[b] - deg[a]);//按祖先节点数量从大到小排序
        if (deg[nodes[0]] != n - 1) return 0; //根节点不满足关系
        int[] fa = new int[max + 1];
        int[][] allFa = new int[max + 1][max + 1];
        //从根开始建树
        for (int i = 0; i < n; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (conn[nodes[i]][nodes[j]] == 1)
                {
                    fa[nodes[i]] = nodes[j];//记录父节点
                    //记录祖先节点， 循环遍历直到根节点
                    for (int f = nodes[j]; f != 0; f = fa[f]) allFa[nodes[i]][f] = 1;
                    break;
                }
            }
        }
        int res = 1;
        for (int i = 1; i <= max; i++)
        {
            for (int j = i + 1; j <= max; j++)
            {
                if (conn[i][j] == 1 && deg[i] == deg[j]) res = 2; //可调换位置
                if (conn[i][j] != (allFa[i][j] | allFa[j][i]) ) return 0;//有冲突，无解， 出现在祖孙节点中，但无连接关系
            }
        }
        return res;
    }
}
