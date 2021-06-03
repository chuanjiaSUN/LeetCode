package tree.day21;

import tree.day20.exercise814;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 11:30
 */
public class exercise863 {
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
    Map<TreeNode, TreeNode> parent;//给每一个赋予 父节点的引用
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       parent = new HashMap<>();
       dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node == null)
            {
                if (dist == k)
                {
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode n : queue)
                    {
                        ans.add(n.val);
                    }
                    return ans;
                }
                queue.offer(null);
                dist++;
            }else
            {
                if (!seen.contains(node.left))
                {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right))
                {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par))
                {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }

    private void dfs(TreeNode root, TreeNode par) {
        if (root != null)
        {
            parent.put(root, par);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
