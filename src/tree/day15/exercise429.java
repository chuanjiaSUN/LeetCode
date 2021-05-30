package tree.day15;

import tree.day13.exercise508;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-28 10:07
 */
public class exercise429 {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null)
                {
                    List<Node> childrens = node.children;
                    for (int j = 0; j < childrens.size(); j++)
                    {
                        queue.offer(childrens.get(j));
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }

    //简化的bfs
    public List<List<Integer>> levelOrder1(Node root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty())
        {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for (Node node : previousLayer)
            {
                vals.add(node.val);
                currentLayer.addAll(node.children);
            }
            ans.add(vals);
            previousLayer = currentLayer;
        }
        return ans;
    }

    //递归
    public List<List<Integer>> levelOrder2(Node root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) traversNode(root, 0, ans);
        return ans;
    }

    private void traversNode(Node root, int depth, List<List<Integer>> ans) {
        if (ans.size()  <= depth) ans.add(new ArrayList<>());
        ans.get(depth).add(root.val);
        for (Node child : root.children)
        {
            traversNode(child, depth + 1, ans);
        }
    }

}
