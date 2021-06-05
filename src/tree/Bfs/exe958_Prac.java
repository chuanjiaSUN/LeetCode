package tree.Bfs;

import tree.day23.exercise958;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-05 12:07
 */
public class exe958_Prac {
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
    class ANode
    {
        TreeNode node;
        int code;
        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
    public boolean isCompleteTree(TreeNode root)
    {
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root, 1));
        int i = 0;

        while (i < list.size())
        {
            ANode node = list.get(i++);//BFS同时移动指针
            if (node.node != null)
            {
                list.add(new ANode(node.node.left, node.code * 2));
                list.add(new ANode(node.node.right, node.code * 2 + 1));
            }
        }
        return list.get(i - 1).code == list.size();
    }
}
