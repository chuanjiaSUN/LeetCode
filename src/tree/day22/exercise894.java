package tree.day22;

import tree.generateTree.exe889_Prac;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 10:22
 */
public class exercise894 {
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
    Map<Integer, List<TreeNode>> memo;
    public List<TreeNode> allPossibleFBT(int n) {
        memo = new HashMap<>();
        if (!memo.containsKey(n))
        {
            List<TreeNode> ans = new ArrayList<>();
            if (n == 1)ans.add(new TreeNode(0));
            else if( n % 2 == 1)
            {
                for (int x = 0; x < n; x++)
                {
                    int y = n - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                    {
                        for (TreeNode right : allPossibleFBT(y))
                        {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            ans.add(root);
                        }
                    }
                }
            }
            memo.put(n, ans);
        }
        return memo.get(n);
    }

    // 递归
    public List<TreeNode> allPossibleFBT1(int n)
    {
        List<TreeNode> ans = new ArrayList<>();
        dfs(n, ans);
        return ans;
    }

    private void dfs(int n, List<TreeNode> ans) {
        if (n == 1) {
            ans.add(new TreeNode(0));
            return;
        }
        for (int i = 1; i < n - 1; i += 2)
        {
            List<TreeNode> left = new ArrayList<>();
            List<TreeNode> right = new ArrayList<>();
            dfs(i, left);
            dfs(n - 1 - i, right);
            for (TreeNode l : left)
            {
                for (TreeNode r : right)
                {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
    }

}
