package tree.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-01 11:35
 */
public class exercise701 {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode pos = root;
        while (pos != null)
        {
            if (val < pos.val)
            {
                if (pos.left == null)
                {
                    pos.left = new TreeNode(val);
                    break;
                }else
                {
                    pos = pos.left;
                }
            }else
            {
                if (pos.right == null)
                {
                    pos.right = new TreeNode(val);
                    break;
                }else
                {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
