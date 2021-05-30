package Arrays.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-07 15:04
 */
public class exercise1 {

    public int[] twoSum(int[] nums, int target) {
    int length = nums.length;
    int i,j,k;
    int[] res=new int[2];
    for(i=0;i<length;i++){
        j = target - nums[i];
        k = length -1;
        while(k>i){
            if(nums[k]==j){
                res[0] = i;
                res[1] = k;
                return res;
            }
            k--;
        }
    }
    return res;
}

//法2 哈希表
    /*
    使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。

这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。

时间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。对于每一个元素 x，我们可以 O(1)O(1) 地寻找 target - x。

空间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销
    * */
    public int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            if (hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        exercise1 e = new exercise1();
        int[] nums = {3,2,4};
        int[] ints = e.twoSum(nums, 6);
        for (int i:ints){
            System.out.println(i);
        }
    }
}
