package tree.day32;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-14 10:26
 */
public class ThroneInheritance {
    private String king;
    Map<String, List<String>> children = new HashMap<>();
    Set<String> deadSet = new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children.get(parentName).add(childName);
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        deadSet.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(king, ans);
        return ans;
    }

    private void dfs(String king, List<String> ans) {
        if (!deadSet.contains(king)) ans.add(king);
        for (String child : children.get(king))
        {
            dfs(child, ans);
        }
    }
}
