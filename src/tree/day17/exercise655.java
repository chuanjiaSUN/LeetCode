package tree.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-30 10:46
 */
public class exercise655 {
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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][ (1 << height) - 1];
        for (String[] arr : res)
        {
            Arrays.fill(arr, "");
        }
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res)
        {
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }

    private void fill(String[][] res, TreeNode root, int depth, int left, int right) {
        if (root == null) return;
        res[depth][ (left + right) >> 1] = "" + root.val;
        fill(res, root.left, depth + 1, left, (left + right) >> 1);
        fill(res, root.right, depth + 1, (left + right + 1) >> 1, right);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
