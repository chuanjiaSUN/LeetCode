package Arrays.day28;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-05 9:46
 */
public class exercise769 {
    //栈
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr)
        {
            if(!stack.isEmpty() && num < stack.peek())
            {
                int head = stack.pop();
                while (!stack.isEmpty() && num < stack.peek())
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

    //双指针
    public int maxChunksToSorted1(int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length; ) {
            int j = i + 1;
            for (; j <= arr[i]; j++) {
                if (arr[j] > arr[i]) { // 在arr[i]到其正确位置的区间内，有比它大的数，不能分为一个块
                    break;
                }
            }
            if (j <= arr[i]) { // j <= arr[i]意味着：在arr[i]在其正确位置区间内，有比它大的数
                i = j; // 指针i移动到j，arr[i]成为当前最大的数字，下一次循环要去判断[j + 1,arr[i]]内有没有比它大的数
            } else {
                count++;
                i = arr[i] + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {0,1};
        exercise769  e = new exercise769();
        int i = e.maxChunksToSorted(arr);
        System.out.println(i);
    }
}
