package tree.swordOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-20 9:49
 */
public class sword68 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<TreeNode, TreeNode> parent;
    Set<TreeNode> visited;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<>();
        visited = new HashSet<>();
        dfs(root, null);
        while (p != null)
        {
            if (!visited.contains(p))
            {
                visited.add(p);
            }
            p = parent.get(p);
        }
        while (q != null)
        {
            if (visited.contains(q))
            {
                return q;
            }
            visited.add(q);
            q = parent.get(q);
        }
        return null;
    }

    private void dfs(TreeNode root, TreeNode father) {
        if (root == null) return;
        parent.put(root, father);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    //法2
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode cur = root;
        while (true)
        {
            if (cur.val > p.val && cur.val > q.val)
            {
                cur = cur.left;
            }else if (cur.val < p.val && cur.val < q.val)
            {
                cur = cur.right;
            }else break;
        }
        return cur;
    }

}
