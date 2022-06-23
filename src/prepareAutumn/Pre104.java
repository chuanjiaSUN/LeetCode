package prepareAutumn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-23 22:02
 */
public class Pre104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node != null && node.left != null){
                    queue.offer(node.left);
                }
                if (node != null && node.right != null){
                    queue.offer(node.right);
                }
            }
            ans++;
        }
        return ans;
    }

        public int maxDepth1(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root == null){
                return 0;
            }
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
}
