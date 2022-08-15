import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String failed = "failed";
        int i1 = str.indexOf(failed);
        int i2 = str.lastIndexOf(failed);
        String baseStr = str.replace(failed, "");
        if (baseStr.length() == 0){
            System.out.println(1);
            return;
        }
        Map<Character, Integer> letters = new HashMap<>();
        char[] chars = {'f', 'a', 'i', 'l', 'e', 'd'};
        Set<Character> set = new HashSet<Character>(){{
            add('f');
            add('a');
            add('i');
            add('l');
            add('e');
            add('d');
        }};
        for (int i = 0; i < baseStr.length(); i++){
            char key = baseStr.charAt(i);
            if (!set.contains(key)){
                System.out.println(-1);
                return;
            }
            letters.put(key, letters.getOrDefault(key, 0) + 1);
        }
        int check = check(letters, failed);
        if (letters.size() > 0 && check == -1){
            System.out.println(-1);
            return;
        }
        if (baseStr.length() == str.length()){
            System.out.println(check);
        }else if (baseStr.length() < str.length()){
            if (i1 == i2){
                System.out.println(check + 1);
            }else{
                System.out.println(check + 2);
            }
        }
    }

    private static int check(Map<Character, Integer> letters, String failed) {
        char[] chars = {'f', 'a', 'i', 'l', 'e', 'd'};
        List<Integer> list = new ArrayList<>();
        Set<Character> keySet = letters.keySet();
        if (keySet.size() != 6){
            return -1;
        }
        for (char ch : chars){
            list.add(letters.getOrDefault(ch, 0));
        }
        int base = list.get(0);
        for (int i = 0; i < list.size(); i++){
            if (base != list.get(i)){
                return -1;
            }
        }
        return base;
    }
}