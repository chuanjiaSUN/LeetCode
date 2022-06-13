package LinkedList.day40;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-15 15:50
 */
public class DFS_DongGui_exercise1367 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

        @Override
        public String toString() {
            return "prepareAutumn.ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){this.val = val; this.left = left; this.right = right;}
    }
    //法1 dfs
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(head, root)||isSubPath(head, root.left)||isSubPath(head,root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if(head.val != root.val) return false;
        return dfs(head.next, root.left)||dfs(head.next, root.right);
    }


}
