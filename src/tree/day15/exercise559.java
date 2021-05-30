package tree.day15;

import javafx.util.Pair;

import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-28 10:37
 */
public class exercise559 {
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

    //DFS方法
    int ans = 0;
    public int maxDepth(Node root) {
        dfs(root);
        return ans;
    }

    private int dfs(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (int i = 0;root.children != null && i < root.children.size(); i++)
        {
            maxDepth = Math.max(dfs(root.children.get(i)), maxDepth);
        }
        ans = Math.max(ans, maxDepth + 1);
        return maxDepth + 1;
    }

    //迭代
    public int maxDepth1(Node root)
    {
        Stack<Pair<Node, Integer>> stack = new Stack<>();
        if (root != null)
        {
            stack.add(new Pair<>(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty())
        {
            Pair<Node, Integer> current = stack.pop();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null)
            {
                depth = Math.max(depth, currentDepth);
                for (Node c : root.children)
                {
                    stack.add(new Pair<>(c, currentDepth + 1));
                }
            }
        }
        return depth;
    }

}
