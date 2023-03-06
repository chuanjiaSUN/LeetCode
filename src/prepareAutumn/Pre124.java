package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-24 21:46
 */
public class Pre124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int prev = left + right + root.val;
        ans = Math.max(ans, prev);
        return root.val + Math.max(left, right);
    }

    /**
     * practice
     * */
    int res = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        backTravel(root);
        return res;
    }

    private int backTravel(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = backTravel(root.left);
        int right = backTravel(root.right);
        int ans = left + right + root.val;
        res = Math.max(res, ans);
        return Math.max(left, right) + root.val;
    }

    /**
     * pracgtice
     * */
    int res_1 = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        deepFirstSearch(root);
        return res_1;
    }

    private int deepFirstSearch(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int ans = root.val;
            int left = Math.max(deepFirstSearch(root.left), 0);
            int right = Math.max(deepFirstSearch(root.right), 0);
            res_1 = Math.max(res_1, ans + left + right);
            return Math.max(ans + left, ans + right);
        }
    }

    /**
     * prac
     * */
        int result = Integer.MIN_VALUE;
        public int maxPathSum3(TreeNode root) {
            calMaxSum(root);
            return result;
        }

        private int calMaxSum(TreeNode root) {
            if (root == null){
                return 0;
            }else{
                int left = Math.max(0, calMaxSum(root.left));
                int right = Math.max(0, calMaxSum(root.right));
                result = Math.max(result, root.val + right + left);
                return Math.max(left, right) + root.val;
            }
        }
}
