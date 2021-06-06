package tree.DFS;

import tree.day24.exercise987;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-06 14:46
 */
public class exe987_Prac {
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
    class Location implements Comparable<Location>
    {
        int clo, row, val;
        Location(int clo, int row, int val)
        {
            this.clo = clo;
            this.row = row;
            this.val = val;
        }

        @Override
        public int compareTo(Location o) {
            if (this.clo != o.clo) return Integer.compare(this.clo, o.clo);
            else if (this.row != o.row) return Integer.compare(this.row, o.row);
            else return Integer.compare(this.val, o.val);
        }
    }
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root)
    {
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);//按照 列、 行 、val排序

        List<List<Integer>> ans = new ArrayList<>();
        int prev = locations.get(0).clo;
        ans.add(new ArrayList<>());

        for (Location loc : locations)
        {
            if (prev != loc.clo)
            {
                prev = loc.clo;
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    private void dfs(TreeNode root, int clo, int row) {
        if (root != null)
        {
            locations.add(new Location(clo, row, root.val));
            dfs(root.left, clo - 1, row + 1);
            dfs(root.right, clo + 1, row + 1);
        }
    }
}
