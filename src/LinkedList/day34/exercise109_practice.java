package LinkedList.day34;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-09 14:55
 */
public class exercise109_practice {
    class ListNode{
        private int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val)
        {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //法1 分治
    public TreeNode sortedListToBST(ListNode head)
    {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, Object right) {
        if( left == right)
        {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode();
        root.val = mid.val;
        root.left = buildTree(left, mid);//左闭右开区间
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMedian(ListNode left, Object right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //法2 中序遍历 + 分治 ， 就不用每次寻找中位数建立根节点了， 原链表排序就是中序遍历的结果
    // 这个方法需要一个占位符，来指明建立好空子树后，应该填值的 链表节点的位置
    private ListNode curRootNode;
    public TreeNode sortedListToBST1(ListNode head)
    {
        curRootNode = head;
        int length = getLength(head);
        return buildMidOrderTree(0, length - 1);
    }

    //利用不同的区间长度，中序遍历建立二叉树   区间为左闭右闭区间
    private TreeNode buildMidOrderTree( int left, int right) {
        if( left > right) return null;
        int mid = ( 1 + left + right ) >> 1;
        TreeNode root = new TreeNode();
        root.left = buildMidOrderTree(left , mid - 1);
        root.val = curRootNode.val;
        curRootNode = curRootNode.next;
        root.right = buildMidOrderTree( mid + 1, right);
        return root;
    }

    private int getLength(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }
}
