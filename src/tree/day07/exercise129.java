package tree.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 9:41
 */
public class exercise129 {
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
    //法1 dfs
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        if (root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        else{
            return dfs(root.left, sum) + dfs(root.right, sum);
        }

    }

    //法2 bfs
    public int sumNumbers1(TreeNode root)
    {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueNum = new LinkedList<>();
        queueNode.offer(root);
        queueNum.offer(root.val);
        while (!queueNode.isEmpty())
        {
            TreeNode node = queueNode.poll();
            int num = queueNum.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null)
            {
                sum += num;
            }else{
                if (left != null)
                {
                    queueNode.offer(left);
                    queueNum.offer(num* 10 + left.val);
                }
                if (right != null)
                {
                    queueNode.offer(right);
                    queueNum.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
