package tree.Mirrors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 13:14
 */
public class exe94_prac {
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

    //使用Morris进行中序遍历，可以节约维护遍历过的左子树的空间，将非递归的中序遍历空间复杂度降低到O(1)

    //就是在遍历到一个节点的时候，找到它的左子树最后边节点X，然后将X 指向该节点，
    //这样在中序遍历完左子树后，就通过这个指针回到X，
    //注意，当每一个左子树遍历完后，需要断开它与前驱X的连接，恢复原本树的结构
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        TreeNode pre = null;

        //开始遍历
        while (root != null)
        {
            if (root.left != null)
            {
                pre = root.left;//初始化遍历节点的 pr
                while (pre.right != null && pre.right != root)//pre.right != root 是为了防止 pre指针一直往后走，走到root去，它需要作为当前root的前驱
                {
                    pre = pre.right;
                }
                //找到的最右节点： 连接前驱 与 当前的root
                if (pre.right == null)
                {
                    pre.right = root;
                    root = root.left;
                }else// 若 pre.right不为空，说明走到了之前连接root的前驱节点位置，也就说明中序遍历到右子树，即左子树遍历完了
                {
                    ans.add(root.val);
                    pre.right = null;
                    root = root.right;
                }

            }else//无左节点，直接访问右节点
            {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
