package Arrays.day24;

/**
 * @author sunchuanjia
 * @Description 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.

 * 输入: n = 3, k = 1
 * 输出: [1, 2, 3]
 * 解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1

 * 输入: n = 3, k = 2
 * 输出: [1, 3, 2]
 * 解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 *
 * @create 2021-03-30 11:37
 */
public class exercise667 {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        for(int i=1;i<n-k;i++)
        {
            answer[i - 1] = i;
        }
        int m = 1;
        int l = k + 1;
        for(int i = n - k - 1;i<n;i++)
        {
            if( (i - (n - k - 1)) % 2 == 0)
            {
                answer[i] = m++;
                answer[i] += (n-k-1);
            }else{
                answer[i] = l;
                answer[i] += (n - k - 1);
                l--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        exercise667 e = new exercise667();
        int[] ints = e.constructArray(5, 4);
        for(int num:ints)
        {
            System.out.println(num);
        }
    }
}
