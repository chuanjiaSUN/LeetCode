package tree.DFS;

import tree.day24.exercise971;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-06 14:34
 */
public class exe971_Prac {
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
    int index;//指向数组
    List<Integer> ans;//存储翻转节点的值
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage)
    {
        index = 0;
        ans = new ArrayList<>();
        dfs(root, voyage);
        if (ans.size() > 0 && ans.get(0) == -1)
        {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (root != null)
        {
            if (root.val != voyage[index++])
            {
                ans.clear();
                ans.add(-1);
                return;
            }
            if (index < voyage.length &&root.left != null && root.left.val != voyage[index++])
            {
                ans.add(root.val);
                dfs(root.right, voyage);
                dfs(root.left,voyage);
            }else
            {
                dfs(root.left, voyage);
                dfs(root.right, voyage);
            }
        }
    }
}
