package tree.day26;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 10:24
 */
public class exercise1028 {
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
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;

        while (pos < traversal.length())
        {
            //取深度
            int level = 0;
            while (traversal.charAt(pos) == '-')
            {
                pos++;
                level++;
            }
            int value = 0;
            //取数
            while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos)))
            {
                value = value * 10 + (traversal.charAt(pos) - '0');
                pos++;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size())
            {
                if (!path.isEmpty())
                {
                    path.peek().left = node;
                }
            }else
            {
                while (level != path.size())
                {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1)
        {
            path.pop();
        }
        return path.peek();
    }



}
