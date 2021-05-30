package tree.day09;

import sun.reflect.generics.tree.Tree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-22 15:28
 */
public class exercise235 {
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
    //2次遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++)
        {
            if (pathP.get(i) == pathQ.get(i))
            {
                ancestor = pathP.get(i);
            }else
            {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> ans = new ArrayList<>();
        TreeNode node = root;
        while (node != target)
        {
            ans.add(node);
            if (node.val < target.val)
            {
                node = node.right;
            }else
            {
                node = node.left;
            }
        }
        ans.add(node);
        return ans;
    }

    //一次遍历
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode ancestor = root;
        while (true)
        {
            if (p.val < ancestor.val && q.val < ancestor.val)
            {
                ancestor = ancestor.left;
            }else if (p.val > ancestor.val && q.val > ancestor.val)
            {
                ancestor = ancestor.right;
            }else
            {
                break;
            }
        }
        return ancestor;
    }

}
