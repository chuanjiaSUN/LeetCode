package newCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-05-07 14:32
 */
public class Leet433 {

        public int minMutation(String start, String end, String[] bank) {
            Set<String> strs = new HashSet<String>();
            Set<String> visited = new HashSet<String>();
            for(String word : bank){
                strs.add(word);
            }
            if(!strs.contains(end)){
                return -1;
            }
            if(start.equals(end)){
                return 0;
            }
            char[] keys = new char[]{'A', 'C', 'G', 'T'};

            Queue<String> queue = new ArrayDeque<>();
            queue.offer(start);
            visited.add(start);
            int step = 1;

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String word = queue.poll();
                    System.out.println(word);
                    for(int index = 0; index < 8; index++){
                        char original = word.charAt(index);
                        for(int k = 0; k < 4; k++){
                            if(keys[k] != original){
                                char[] arrs = word.toCharArray();
                                arrs[index] = keys[k];
                                String newWord = new String(arrs);
                                System.out.println("newWord: " + newWord);
                                if(!visited.contains(newWord) && strs.contains(newWord)){
                                    if(newWord.equals(end)){
                                        return step;
                                    }
                                    queue.offer(newWord);
                                    visited.add(newWord);
                                }
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }

    public static void main(String[] args) {
        Leet433 leet433 = new Leet433();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int i = leet433.minMutation(start, end, bank);
        System.out.println(i);

    }
}
