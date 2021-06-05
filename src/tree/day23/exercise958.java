package tree.day23;

import sun.reflect.generics.tree.Tree;
import tree.day22.exercise951;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-05 10:46
 */
public class exercise958 {
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
    class ANode{
        TreeNode node;
        int code;
        ANode(TreeNode node, int code)
        {
            this.node = node;
            this.code = code;
        }
    }
    //BFS
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList<>();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while ( i < nodes.size())
        {
            ANode node = nodes.get(i++);
            if (node.node != null)
            {
                nodes.add(new ANode(node.node.left, node.code * 2));
                nodes.add(new ANode(node.node.right, node.code * 2 + 1));
            }
        }
        return nodes.get(i - 1).code == nodes.size();
    }
}
