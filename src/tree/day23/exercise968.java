package tree.day23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-05 11:10
 */
public class exercise968 {
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
    // Dynamic Plan
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }

    //法2
    int result;
    public int minCameraCover1(TreeNode root)
    {
        result = 0;
        if (travel(root) == 0)
        {
            result++;
        }
        return result;
    }

    // 0表示无覆盖， 1为该结点有camera,2为该结点被覆盖
    private int travel(TreeNode root) {
        if (root == null) return 2;
        int left = travel(root.left);
        int right = travel(root.right);

        //左右都被覆盖，但无摄像头
        if (left == 2 && right == 2) return 0;

        //左右中有1个未被覆盖， 根节点放摄像头
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }

        //左右结点含摄像头， 根节点被覆盖
        if (left == 1 || right == 1) return 2;

        return -1;
    }

}
