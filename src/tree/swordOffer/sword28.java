package tree.swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-18 11:43
 */
public class sword28 {
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
    //BFS
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                    list.add(node.left.val);
                }else{
                    list.add(-1);
                }
                if (node.right != null){
                    queue.offer(node.right);
                    list.add(node.right.val);
                }else{
                    list.add(-1);
                }
            }
            if (!check(list)) return false;
        }
        return true;
    }

    private boolean check(List<Integer> list) {
        int high = list.size() - 1;
        for (int low = 0; low <= high; low++)
        {
            if (!list.get(low).equals(list.get(high)) ) return false;
            high--;
        }
        return true;
    }

    //DFS
    public boolean isSymmetric1(TreeNode root)
    {
        return root == null ? true : checkSyn(root.left, root.right);
    }

    private boolean checkSyn(TreeNode left, TreeNode right) {
        if (left ==  null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return checkSyn(left.left, right.right) && checkSyn(left.right, right.left);
    }
}
