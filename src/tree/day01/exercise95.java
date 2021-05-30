package tree.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 13:26
 */
public class exercise95 {
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return Exe95GenerateTrees(1, n);
    }

    private List<TreeNode> Exe95GenerateTrees(int start, int end) {
       List<TreeNode> ans = new ArrayList<>();
       if (start > end)
       {
           ans.add(null);
           return ans;
       }

       for (int i = start; i <= end; i++)
       {
           List<TreeNode> leftTrees = Exe95GenerateTrees(start, i - 1);
           List<TreeNode> rightTrees = Exe95GenerateTrees(i + 1, end);

           for (TreeNode left : leftTrees)
           {
               for (TreeNode right : rightTrees)
               {
                   TreeNode currTree = new TreeNode(i);
                   currTree.left = left;
                   currTree.right = right;
                   ans.add(currTree);
               }
           }
       }
       return ans;
    }
}
