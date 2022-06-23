package prepareAutumn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-23 21:58
 */
public class Pre102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node != null){
                   list.add(node.val);
                }
                if (node != null && node.left != null){
                    queue.offer(node.left);
                }
                if (node != null && node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
