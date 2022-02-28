package num100;


import org.junit.Test;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-27 13:25
 */
public class Exe141 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**快慢指针*/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fir = head;
        ListNode sec = head.next;
        while (fir != sec){
            if (sec == null || sec.next == null){
                return false;
            }
            fir = fir.next;
            sec = sec.next.next;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = scanner.nextLine();
        }
        scanner.close();

        Map<Character, Long> map = new HashMap<>();
        for(char c = 'A'; c <= 'J'; c++){
            map.put(c, (long)0);
        }
        Set<Character> head = new HashSet<>();

        for(int i = 0; i < n; i++){
            head.add(s[i].charAt(0));
            int len = s[i].length();
            for(int j = 0; j < len; j++){
                char ch = s[i].charAt(j);
                map.put(ch, map.get(ch) + (long)Math.pow(10, len - j - 1));
            }
        }

        char min = ' ';
        long minValue = Long.MAX_VALUE;
        for(Character ch : map.keySet()){
            if(!head.contains(ch) && map.get(ch) < minValue){
                min = ch;
                minValue = map.get(ch);
            }
        }

        List<Long> list = new ArrayList<>();
        for(Character ch : map.keySet()){
            if(ch != min){
                list.add(map.get(ch));
            }
        }
        Collections.sort(list);
        System.out.println(list);
        list.add(minValue);
        System.out.println(list);
        long sum = 0;
        int p = 1;
        for(long e : list){
            if(p == 10)break;
            sum += e * p++;
        }
        System.out.println(sum);
    }

    @Test
    public void test1(){
        StringBuffer sb = new StringBuffer();
        java.lang.String[] strs1 = new java.lang.String[]{"111","222","333"};
        sb.append(strs1[0]);
        sb.append(strs1[1]);
        sb.delete(sb.length() - strs1[1].length() , sb.length());
        System.out.println(sb.toString());
    }
}
