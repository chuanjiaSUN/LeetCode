package tree.day27;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-09 14:57
 */
public class exercise1302 {
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
    int maxLevel;
    int[] levelSum = new int[10000];
    public int deepestLeavesSum(TreeNode root) {
        maxLevel = 0;
        dfs(root, 0);
        return levelSum[maxLevel];
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        levelSum[depth] += root.val;
        maxLevel = Math.max(maxLevel, depth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    //法 2 不用数组存储 sum
    int total;
    int depth;
    public int deepestLeavesSum1(TreeNode root)
    {
        total = 0;
        depth = -1;
        dfs1(root, 0);
        return total;
    }

    private void dfs1(TreeNode root, int level) {
        if (root == null) return;
        if (level > depth)
        {
            total = root.val;
            depth = level;
        } else if (level == depth)
        {
            total += root.val;
        }
        dfs1(root.left, level + 1);
        dfs1(root.right, level + 1);
    }
}
