package tree.day03;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-16 19:54
 */
public class exercise107 {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//       List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<>();
       if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0 ; i < size; i++)
            {
                TreeNode node = queue.poll();
                path.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(0, path);
        }
        return ans;
    }
}
