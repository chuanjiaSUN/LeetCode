package Arrays.day19;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-25 9:37
 */
public class exercise380 {
    class RandomizedSet {
        Map<Integer,Integer> map;
        List<Integer> list;
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
           if(map.containsKey(val)) return false;
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
           if(map.containsKey(val))
           {
               int value = map.get(val);
               int lastElement = list.get(list.size()-1);
               list.set(value,lastElement);
               map.put(lastElement,value);
               list.remove(list.size()-1);
               map.remove(val);
               return true;
           }
           return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return map.get(rand.nextInt(list.size()));
        }
    }

}
