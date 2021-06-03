package tree.day21;

import tree.Bfs.exe865_Prac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 14:59
 */
public class exercise872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list;
        List<Integer> list1;
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        dfs(root1,list);
        dfs(root2,list1);
        return list.equals(list1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null)
        {
            if (root.left == null && root.right == null) list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}
