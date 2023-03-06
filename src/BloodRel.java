import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-10-22 10:46
 */
public class BloodRel {
    static Map<String, String> parent = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String str = sc.nextLine();
            String[] split = str.split(" ");
            String command = split[0];
            String name1 = split[1];
            String name2 = split[2];
            if (command.equals("AddRelationShip")){
                parent.put(name2, name1);
            }else if (command.equals("GetGeneration")){
                int ans = getGeneration(name1, name2);
                System.out.println(ans);
            }else if (command.equals("GetCousin")){
                String cousin = getCousin(name1, name2);
                System.out.println(cousin);
            }
        }
    }

    private static String getCousin(String name1, String name2) {
        Set<String> set = new HashSet<>();
        String cur1 = name1;
        String cur2 = name2;
        while (cur1 != null){
            set.add(cur1);
            cur1 = parent.get(cur1);
        }
        while (cur2 != null){
            if (set.contains(cur2)){
                int left = getGeneration(name1, cur2);
                int right = getGeneration(name2, cur2) - left;
                return left - 1 + " " + right;
            }
            cur2 = parent.get(cur2);
        }
        return "-1";
    }

    private static int getGeneration(String name1, String name2) {
        String cur1 = name1;
        String cur2 = name2;
        int high = 0;
        while (cur1 != null){
            cur1 = parent.get(cur1);
            high++;
            if (cur1 != null && cur1.equals(name2)){
                return high;
            }
        }
        high = 0;
        while (cur2 != null){
            cur2 = parent.get(cur2);
            high++;
            if (cur2 != null && cur2.equals(name1)){
                return high;
            }
        }
        return -1;
    }

}
