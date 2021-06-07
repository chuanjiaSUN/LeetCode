package tree.day25;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 13:35
 */
public class exercise1008 {
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return generate(preorder, 0, preorder.length - 1);
    }

    private TreeNode generate(int[] preorder, int start, int end) {
        if (start > end) return null;
        int rootIndex = start;
        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        if (start == end) return root;
        int leftEnd = checkSmall(start, end, preorder);//左子树的右边界，可以取到
        int leftRoot = start + 1;
        root.left = generate(preorder, leftRoot, leftEnd);
        root.right = generate(preorder,leftEnd + 1, end);
        return root;
    }

    private int checkSmall(int low, int high,int[] preorder) {
//        int rootVal = preorder[low];
//        while (low < high)
//        {
//            int mid = (low + high + 1) >> 1;
//            if (preorder[mid] > rootVal) high = mid - 1;
//            else low = mid;
//        }
//        return low;
        int ans = 0, val = preorder[low];
        for (int i = low; i < high; i++)
        {
            if (preorder[i] < val)
            {
                ans = i;
            }else break;
        }
        return ans;
    }
}
