package tree.day16;

import tree.day15.exercise429;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 13:03
 */
public class exercise589 {
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

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        for (int i = 0; root.children != null && i < root.children.size(); i++)
        {
            dfs(root.children.get(i), ans);
        }
    }

    //迭代
    public List<Integer> preorder1(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            root = stack.pop();
            ans.add(root.val);
            if (root.children != null)
            {
                for (int i = root.children.size() - 1; i >= 0; i--)
                {
                    stack.push(root.children.get(i));
                }
            }
        }
        return ans;
    }
}
