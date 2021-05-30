package tree.day10;

import tree.DFS.exe236_Prac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-23 11:14
 */
public class exercise257 {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, ans, "");
        return ans;
    }

    private void dfs(TreeNode root, List<String> ans, String path) {
        if (root != null)
        {
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            if (root.left == null && root.right == null)
            {
                ans.add(sb.toString());
            }else
            {
                sb.append("->");
                dfs(root.left, ans, sb.toString());
                dfs(root.right, ans, sb.toString());
            }
        }
    }

    //dfs2  ,dfs里隐藏有回溯
    public List<String> binaryTreePaths1(TreeNode root)
    {
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        constructPath(root, ans, sb);
        return ans;
    }

    private void constructPath(TreeNode root, List<String> ans, StringBuffer sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null)
        {
            ans.add(sb.toString());
            return;
        }
        sb.append("->");
        constructPath(root.left, ans, new StringBuffer(sb));
        constructPath(root.right, ans, new StringBuffer(sb));//每次传进去的是原基础上的新字符串，可以不回溯
    }

    public List<String> binaryTreePaths2(TreeNode root)
    {
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs2(root, ans, sb);
        return ans;
    }

    private void dfs2(TreeNode root, List<String> ans, StringBuffer path) {
        if (root == null) return;
        int length = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null)
        {
            ans.add(path.toString());
        }
        path.append("->");
        dfs2(root.left, ans, path);
        dfs2(root.right, ans, path);
        path.delete(length, path.length());//这个必须回溯，因为节点回溯的时候，path已经改变了
    }


}
