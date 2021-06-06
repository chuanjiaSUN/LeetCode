package tree.day24;

import javafx.scene.transform.Rotate;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-06 13:33
 */
public class exercise987 {
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
        int x, y, val;
        Location(int x, int y, int val)
        {
            this.x = x; this.y = y; this.val = val;
        }
        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
            {
                return Integer.compare(this.x, that.x);
            }else if (this.y != that.y)
            {
                return Integer.compare(this.y, that.y);
            }else
            {
                return Integer.compare(this.val, that.val);
            }
        }
    }

    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        int prev = locations.get(0).x;

        for (Location loc : locations)
        {
            if (loc.x != prev)
            {
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }
            ans.get(ans.size() - 1).add(loc.val);
        }
        return ans;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root != null)
        {
            locations.add(new Location(x, y, root.val));
            dfs(root.left, x - 1, y + 1);
            dfs(root.right, x + 1, y + 1);
        }
    }


}
