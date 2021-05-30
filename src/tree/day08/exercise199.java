package tree.day08;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-21 11:13
 */
public class exercise199 {

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

    //BFS 同样深度最右边的值
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if ( i == size - 1) ans.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return ans;
    }

    //DFS 先访问右子树
    public List<Integer> rightSideView1(TreeNode root)
    {
        Map<Integer, Integer> rightMap = new HashMap<>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty())
        {
            //每次最先访问的右子树最右边的节点
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null)
            {
                max_depth = Math.max(depth, max_depth);

                if (!rightMap.containsKey(depth))
                {
                    rightMap.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++)
        {
            ans.add(rightMap.get(depth));
        }
        return ans;
    }
}
