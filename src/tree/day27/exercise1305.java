package tree.day27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-09 15:04
 */
public class exercise1305 {
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
    List<Integer> ans;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ans);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root != null)
        {
            dfs(root.left);
            ans.add(root.val);
            dfs(root.right);
        }
    }


}
