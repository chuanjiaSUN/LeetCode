package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-01 22:26
 */
public class Pre226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
}
