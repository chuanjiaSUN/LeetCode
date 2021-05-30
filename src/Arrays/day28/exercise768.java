package Arrays.day28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-04 13:31
 */
public class exercise768 {
    //法 1 滑动窗口
    public int maxChunksToSorted(int[] arr)
    {
        Map<Integer,Integer> count = new HashMap<>();
        int ans = 0, nonzero = 0;//nonzero用来记录 差值不为0 的字符个数

        int[] expect = arr.clone();
        Arrays.sort(expect);

        //如果前k个元素的个数， 减去排序后前k个元素的个数都为0，那么这k这个元素能成为一个合法的分块。
        for( int i = 0; i < arr.length; i++)
        {
            int x = arr[i] , y = expect[i];

            count.put(x, count.getOrDefault( x, 0) + 1);
            if( count.get(x) == 0) nonzero--; //目前差值为0
            if( count.get(x) == 1) nonzero++;

            count.put(y, count.getOrDefault(y, 0) - 1);
            if( count.get(y) == -1) nonzero++;
            if( count.get(y) == 0) nonzero--;//目前差值为0

            if(nonzero == 0) ans++;
        }
        return  ans;
    }

    //辅助栈法
    public int maxChunksToSorted1(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr)
        {
            if(!stack.isEmpty() && num < stack.peek())
            {
                int head = stack.pop();
                while( !stack.isEmpty() && num < stack.peek())
                {
                    stack.pop();
                }
                stack.push(head);
            }else{
                stack.push(num);
            }
        }
        return stack.size();
    }


    public static void main(String[] args) {
        int[] arr = {4,2,2,1,1};
        exercise768 e = new exercise768();
        int i = e.maxChunksToSorted(arr);
        System.out.println(i);
    }
}
