package tree.day24;

import javafx.geometry.VPos;
import tree.Bfs.exe958_Prac;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-06 11:56
 */
public class exercise971 {
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
    int cur;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        cur = 0;
        dfs(root, voyage);
        if (!ans.isEmpty() && ans.get(0) == -1)
        {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (root != null)
        {
            if (root.val != voyage[cur++])
            {
                ans.clear();
                ans.add(-1);
                return;
            }
            if (cur < voyage.length && root.left != null && root.left.val != voyage[cur])
            {
                ans.add(root.val);
                dfs(root.right, voyage);
                dfs(root.left, voyage);
            }else
            {
                dfs(root.left, voyage);
                dfs(root.right, voyage);
            }
        }
    }


}
