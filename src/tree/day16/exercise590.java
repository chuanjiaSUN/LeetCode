package tree.day16;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 13:28
 */
public class exercise590 {
    class Node{
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postTravel(root, ans);
        return ans;
    }

    private void postTravel(Node root, List<Integer> ans) {
        if (root == null) return;
        if (root.children != null)
        {
            for (int i = 0; i < root.children.size(); i++)
            {
                postTravel(root.children.get(i), ans);
            }
            ans.add(root.val);
        }
    }

    //迭代
    public List<Integer> postorder1(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            Node node = stack.pop();
            if (node.children != null)
            {
                for (int i =0; i < node.children.size(); i++)
                {
                    stack.push(node.children.get(i));
                }
            }
            ans.add(ans.size() - 1, node.val);
        }
        return ans;
    }
}
