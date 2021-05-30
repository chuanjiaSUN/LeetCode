package Arrays.day12;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-18 11:34
 */
public class DFS_exercise106 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    //法1 递归
    public TreeNode buildTree(int[] inorder, int[] postorder){
        int length = inorder.length;
        return DFS_Tree(inorder,postorder,0,length-1,0,length-1);
    }

    private TreeNode DFS_Tree(int[] inorder, int[] postorder, int in_left, int in_right, int post_left, int post_right) {
        if(in_left>in_right || post_left>post_right) return null;

        int post_root_val = postorder[post_right];
        TreeNode root = new TreeNode(post_root_val);

        if(post_left==post_right) return root;

        int in_root = in_left;
        while(inorder[in_root] != postorder[post_right]) in_root++;//获取中序中根节点索引



        root.left = DFS_Tree(inorder,postorder,in_left,in_root-1,post_left,post_left+(in_root-1-in_left));
        root.right = DFS_Tree(inorder,postorder,in_root+1,in_right,post_right-1-(in_right-(in_root+1)),post_right-1);

        return root;
    }

    //法2 迭代
}
