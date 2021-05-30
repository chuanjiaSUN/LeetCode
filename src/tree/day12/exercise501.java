package tree.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-25 10:33
 */
public class exercise501 {
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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        dfs(root, indexMap);
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet())
        {
            if (entry.getValue() > maxCount) maxCount = entry.getValue();
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet())
        {
            if (entry.getValue() == maxCount) ans.add(entry.getKey());
        }
        int[] list = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
        {
            list[i] = ans.get(i);
        }
        return list;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> indexMap) {
        if (root == null) return;
        indexMap.put(root.val, indexMap.getOrDefault(root.val, 0) + 1);
        dfs(root.left, indexMap);
        dfs(root.right, indexMap);
    }

    //中序遍历 二叉搜索树
    List<Integer> answer = new ArrayList<>();
    int baseNum, count, maxCount;
    public int[] findMode1(TreeNode root)
    {
        dfs1(root);
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
        {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        dfs1(root.left);
        update(root.val);
        dfs1(root.right);
    }

    private void update(int val) {
        if (val == baseNum)
        {
            count++;
        }else
        {
            baseNum = val;
            count = 1;
        }
        if (count == maxCount)
        {
            answer.add(val);
        }
        if (count > maxCount)
        {
            maxCount = count;
            answer.clear();
            answer.add(baseNum);
        }
    }

    //Morris算法进行中序遍历， 优化空间复杂度,不用保留已经遍历过的节点值
    public int[] findMode2(TreeNode root)
    {
        TreeNode predecessor = null, cur = root;
        while (cur != null)
        {
            if (cur.left == null)
            {
                update1(cur.val);
                cur = cur.right;
                continue;
            }
            predecessor = cur.left;
            while (predecessor.right != null && predecessor.right != cur)
            {
                predecessor = predecessor.right;
            }
            if (predecessor.right == null)
            {
                predecessor.right = cur;
                cur = cur.left;
            }else
            {
                predecessor.right = null;
                update1(cur.val);
                cur = cur.right;
            }
        }
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
        {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    private void update1(int val) {
        if (val == baseNum)
        {
            count++;
        }else
        {
            baseNum = val;
            count = 1;
        }
        if (count == maxCount)
        {
            answer.add(val);
        }
        if (count > maxCount)
        {
            maxCount = count;
            answer.clear();
            answer.add(baseNum);
        }
    }

}
