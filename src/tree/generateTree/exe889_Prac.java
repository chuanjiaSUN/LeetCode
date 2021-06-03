package tree.generateTree;

import tree.day21.exercise889;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 16:01
 */
public class exe889_Prac {
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
    public TreeNode constructFromPrePost(int[] pre, int[] post)
    {
        indexMap = new HashMap<>();
        for (int i = 0; i < post.length; i++)
        {
            indexMap.put(post[i], i);
        }
        return construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode construct(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) return null;
        int rootIndex = preLeft;
        TreeNode root = new TreeNode(pre[rootIndex]);
        if(preLeft == preRight) return root;
        int leftRoot = preLeft + 1;
        int postLeftIndex = indexMap.get(pre[leftRoot]);
        int leftSize = postLeftIndex - postLeft + 1;
        root.left = construct(pre, preLeft + 1, preLeft  + leftSize, post, postLeft, postLeftIndex);
        root.right = construct(pre, preLeft + leftSize + 1, preRight, post, postLeftIndex + 1, postRight - 1);
        return root;
    }
}
