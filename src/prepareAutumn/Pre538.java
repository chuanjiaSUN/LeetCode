package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-11 22:58
 */
public class Pre538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    /**
     * practice
     * */
    int temp = 0;
    public TreeNode convertBST1(TreeNode root) {
        if (root != null){
            convertBST1(root.right);
            temp += root.val;
            root.val = temp;
            convertBST1(root.left);
        }
        return root;
    }
}
