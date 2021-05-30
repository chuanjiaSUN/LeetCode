package tree.generateTree;

import tree.day01.exercise95;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 14:00
 */
public class exe95_Prac {
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
    public List<TreeNode> generateTrees(int n)
    {
        if (n == 0) return new ArrayList<TreeNode>();
        return geneTrees(1, n);
    }

    private List<TreeNode> geneTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end)
        {
            ans.add(null);
            return ans;
        }
        for (int i = start ; i <= end; i++)
        {
            List<TreeNode> leftTrees = geneTrees(start, i - 1);
            List<TreeNode> rightTrees = geneTrees(i + 1, end);

            for (TreeNode left : leftTrees)
            {
                for (TreeNode right : rightTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
