package tree.Bfs;


import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 11:52
 */
public class exe863_Prac {
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
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root, null);//给每个结点指定父节点

        Queue<TreeNode> queue = new LinkedList<>();//BFS一层一层搜索，搜完一层距离 + 1
        queue.offer(null);
        queue.offer(target);

        Set<TreeNode> visited = new HashSet<>();//表示遍历过的结点
        visited.add(null);
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node == null)//表示搜完了一层
            {
                if (dist == k)
                {
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode ptr : queue)
                    {
                        ans.add(ptr.val);
                    }
                    return ans;
                }
                dist++;
                queue.offer(null);//用来做一层遍历结束的标识
            }else
            {
                if (!visited.contains(node.left))
                {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (!visited.contains(node.right))
                {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);//也要从父节点开始搜索
                if (!visited.contains(par))
                {
                    visited.add(par);
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
