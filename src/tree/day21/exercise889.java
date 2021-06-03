package tree.day21;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 15:05
 */
public class exercise889 {
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
    Map<Integer, Integer> indexMap;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        indexMap = new HashMap<>();
        for (int i = 0; i < post.length; i++)
        {
            indexMap.put(post[i], i);
        }
        return buildTree(pre, 0, pre.length - 1,post, 0, pre.length -1);
    }

    private TreeNode buildTree(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight) {
        if (postLeft > postRight || postLeft > postRight) return null;
        int rootVal = pre[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft == preRight) return root;
        int leftRoot = preLeft + 1;
        int postLeftRoot = indexMap.get(pre[leftRoot]);
        int Leftsize = postLeftRoot - postLeft + 1;
        root.left = buildTree(pre, preLeft + 1, preLeft + Leftsize, post, postLeft, postLeftRoot);
        root.right = buildTree(pre, preLeft + Leftsize + 1, preRight, post, postLeftRoot + 1, postRight - 1);
        return root;
    }
}
