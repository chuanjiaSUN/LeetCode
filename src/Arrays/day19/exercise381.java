package Arrays.day19;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。

 * @create 2021-03-25 10:03
 */
public class exercise381 {
    class RandomizedCollection {
        Map<Integer,Set<Integer>> map;
        List<Integer> list;
        Random rand = new Random();
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            list.add(val);
            Set<Integer> indexSet = map.getOrDefault(val, new HashSet<>());
            indexSet.add(list.size()-1);
            map.put(val,indexSet);
            return indexSet.size()==1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;

            Set<Integer> indexSet = map.get(val);
            Integer removeIdx = indexSet.iterator().next();//获取要删除位置的索引

            Integer lastElement = list.get(list.size() - 1);
            list.set(removeIdx,lastElement);//用最后一个的元素替换
            //修改删除位置元素的索引
            indexSet.remove(removeIdx);
            //修改最后一个位置元素索引
            Set<Integer> lastEleIdx = map.get(lastElement);
            lastEleIdx.remove(list.size()-1);

            if(removeIdx < list.size() - 1)
            {
                lastEleIdx.add(removeIdx);
            }
            if(indexSet.size()==0)
            {
                map.remove(val);
            }

            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(((int)(Math.random() * list.size())));
        }
    }
}
