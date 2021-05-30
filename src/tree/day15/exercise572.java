package tree.day15;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-28 11:07
 */
public class exercise572 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //朴素DFS
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }

    //dfs + kmp
    List<Integer> rootOrder = new ArrayList<>();
    List<Integer> subOrder = new ArrayList<>();
    int maxElement, lNull, rNull;
    public boolean isSubtree1(TreeNode root, TreeNode subRoot)
    {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(root);
        getMaxElement(subRoot);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(root, rootOrder);
        getDfsOrder(subRoot, subOrder);

        return kmp();
    }

    private boolean kmp() {
        int rootLen = rootOrder.size(), subLen = subOrder.size();
        int[] fail = new int[subLen];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < subLen; i++)
        {
            while ( j != -1 && !(subOrder.get(i).equals(subOrder.get(j + 1))))
            {
                j = fail[j];
            }
            if (subOrder.get(i).equals(subOrder.get(j + 1)))
            {
                j++;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < rootLen; i++)
        {
            while ( j != -1 && !(rootOrder.get(i).equals(subOrder.get(j + 1))))
            {
                j = fail[j];
            }
            if (rootOrder.get(i).equals(subOrder.get(j + 1)))
            {
                j++;
            }
            if (j == subLen - 1)
            {
                return true;
            }
        }
        return false;
    }

    private void getDfsOrder(TreeNode root, List<Integer> rootOrder) {
        if (root == null) return;
        rootOrder.add(root.val);
        if (root.left != null)getDfsOrder(root.left, rootOrder);
        else rootOrder.add(lNull);
        if (root.right != null)getDfsOrder(root.right, rootOrder);
        else rootOrder.add(rNull);
    }

    private void getMaxElement(TreeNode t) {
        if (t == null) return;
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }


    //树哈希
    static final int MAX_N = 1005;
    static final int MOD = 1000000007;
    boolean[] vis = new boolean[MAX_N];
    int[] p = new int[MAX_N];
    int tot;
    Map<TreeNode, int[]> mapRoot = new HashMap<>();
    Map<TreeNode, int[]> mapSub = new HashMap<>();

    public boolean isSubtree2(TreeNode s, TreeNode t)
    {
        getPrime();
        dfs1(s, mapRoot);
        dfs1(t, mapSub);

        int tHash = mapSub.get(t)[0];
        for (Map.Entry<TreeNode, int[]> entry : mapRoot.entrySet())
        {
            if (entry.getValue()[0] == tHash) return true;
        }
        return false;
    }

    private void dfs1(TreeNode node, Map<TreeNode,int[]> map) {
        map.put(node, new int[]{node.val, 1});
        if (node.left == null && node.right == null) return;
        if (node.left != null)
        {
            dfs1(node.left, map);
            int[] val = map.get(node);
            val[1] += map.get(node.left)[1];//标定第几个节点
            val[0] = (int) ((val[0] + (31L * map.get(node.left)[0] * p[map.get(node.left)[1]]) % MOD) % MOD);
        }
        if (node.right != null)
        {
            dfs1(node.right, map);
            int[] val = map.get(node);
            val[1] += map.get(node.right)[1];//标定第几个节点
            val[0] = (int)((val[0] + (179L * map.get(node.right)[0] * p[map.get(node.right)[1]]) % MOD) % MOD);
        }
    }

    //求素数
    private void getPrime() {
        vis[0] = vis[1] = true;
        tot = 0;
        for (int i = 2; i < MAX_N; i++)
        {
            if (!vis[i]) p[++tot] = i;
            for (int j = 1; j <= tot && i * p[j] < MAX_N; j++)
            {
                vis[i * p[j]] = true;
                if ( i % p[j] == 0)
                {
                    break;
                }
            }
        }
    }
}
