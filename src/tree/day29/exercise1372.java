package tree.day29;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 11:43
 */
public class exercise1372 {
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
    int ans;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return ans;
    }

    private void dfs(TreeNode root, boolean dir, int len) {
        ans = Math.max(ans, len);
        if (!dir)
        {
            if (root.left != null)
            {
                dfs(root.left, true, len + 1);
            }
            if (root.right != null)
            {
                dfs(root.right, false,  1);
            }
        }else
        {
            if (root.right != null)
            {
                dfs(root.right, false, len + 1);
            }
            if (root.left != null)
            {
                dfs(root.left, true, 1);
            }
        }
    }
    // 法2 DP
    Map<TreeNode, Integer> f = new HashMap<>();// 左儿子路径
    Map<TreeNode, Integer> g = new HashMap<>();// 右儿子路径
    Queue<TreeNode[]> queue = new LinkedList<>();
    public int longestZigZag1(TreeNode root)
    {
        dp(root);
        int maxAns = 0;
        for (TreeNode node : f.keySet())
        {
            maxAns = Math.max(maxAns, Math.max(f.get(node), g.get(node)));
        }
        return maxAns;
    }

    private void dp(TreeNode root) {
        f.put(root, 0);
        g.put(root, 0);
        queue.offer(new TreeNode[]{root, null});
        while (!queue.isEmpty())
        {
            TreeNode[] path = queue.poll();
            TreeNode u = path[0], x = path[1];
            f.put(u, 0);
            g.put(u, 0);
            if (x != null)
            {
                if (x.left == u)
                {
                    f.put(u, g.get(x) + 1);
                }
                if (x.right == u)
                {
                    g.put(u, f.get(x) + 1);
                }
            }
            if (u.left != null)
            {
                queue.offer(new TreeNode[]{u.left, u});
            }
            if (u.right != null)
            {
                queue.offer(new TreeNode[]{u.right, u});
            }
        }
    }

}
