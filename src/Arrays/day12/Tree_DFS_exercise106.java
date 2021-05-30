package Arrays.day12;

import Arrays.day11.DFS_Tree_Array_exercise105;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-18 10:33
 */
public class Tree_DFS_exercise106 {
    private int post_root_index;
    private int[] postorder;
    private int[] inorder;
    private Map<Integer,Integer> indexMap1;
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

    /*
    * 为了高效查找根节点元素在中序遍历数组中的下标，我们选择创建哈希表来存储中序序列，即建立一个（元素，下标）键值对的哈希表。
定义递归函数 helper(in_left, in_right) 表示当前递归到中序序列中当前子树的左右边界，递归入口为helper(0, n - 1) ：
如果 in_left > in_right，说明子树为空，返回空节点。
选择后序遍历的最后一个节点作为根节点。
利用哈希表 O(1)O(1) 查询当根节点在中序遍历中下标为 index。从 in_left 到 index - 1 属于左子树，从 index + 1 到 in_right 属于右子树。
根据后序遍历逻辑，递归创建右子树 helper(index + 1, in_right) 和左子树 helper(in_left, index - 1)。注意这里有需要先创建右子树，再创建左子树的依赖关系。可以理解为在后序遍历的数组中整个数组是先存储左子树的节点，
* 再存储右子树的节点，最后存储根节点，如果按每次选择「后序遍历的最后一个节点」为根节点，则先被构造出来的应该为右子树。
返回根节点 root。
。*/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||inorder==null) return null;
        int length = inorder.length;
        indexMap1 = new HashMap<>();
        post_root_index = postorder.length - 1;
        this.postorder = postorder;
        this.inorder =inorder;
        for(int i=0;i<length;i++)
        {
            indexMap1.put(inorder[i],i);
        }
        return getMyTree(0,length-1);
    }

    private TreeNode getMyTree(int in_order_left, int in_order_right) {
        if(in_order_left>in_order_right) return null;

        int root_val = postorder[post_root_index];
        TreeNode root = new TreeNode(root_val);

        int inOrder_root = indexMap1.get(postorder[post_root_index]);//中序遍历的根节点索引

        post_root_index--;

        root.right = getMyTree(inOrder_root+1,in_order_right);//这里先建造右子树是因为通过post_root_index访问的后续遍历的根节点，它位于右子树
        root.left = getMyTree(in_order_left,inOrder_root-1);
        return root;
    }

    //法2 迭代 找清楚后序遍历中，反向后序遍历元素与前一元素关系，并且遍历到的元素，与反向中序遍历元素的关系
    public TreeNode buildTree1(int[] inorder, int[] postorder){
        if(inorder.length==0||inorder==null)return null;

        int length = inorder.length;
        TreeNode root = new TreeNode(postorder[length-1]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int indexOfInOrder = inorder.length - 1;
        for(int i=length-2;i>=0;i--)//从后续遍历第length - 2位置开始。length - 1位置为根节点
        {
            //反向遍历后序遍历数组
            int postValue = postorder[i];
            TreeNode node = stack.peek();
            //1 index指向与当前栈顶不同时，当前遍历元素作为栈顶的右孩子，当前元素入栈
            if(inorder[indexOfInOrder] != node.val){
                node.right = new TreeNode(postValue);
                stack.push(node.right);
            }else{
                //2 当栈不为空，且index指向元素与栈顶元素相同时，栈弹出元素，index向前移动，最后一个弹出元素为当前遍历元素(作为左孩子)的父节点，
                while(!stack.isEmpty() && inorder[indexOfInOrder]==stack.peek().val)
                {
                   node = stack.pop();
                    indexOfInOrder--;
                }
                node.left = new TreeNode(postValue);
                stack.push(node.left);
            }
        }
        return root;
    }

}
