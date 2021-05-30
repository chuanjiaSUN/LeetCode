package Arrays.day21;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-27 10:05
 */
public class exercise509 {
    //递归
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1) return 1;
        else{
            return fib(n-1) + fib(n-2);
        }
    }
    //动态规划 f(n) = f(n-1) + f(n-2)
    public int fib1(int n){
        if(n < 2) return n;
        int left = 0,right = 0,answer = 1;
        for(int i=2;i<=n;i++)
        {
            left = right;
            right = answer;
            answer = left + right;
        }
        return answer;
    }

    public static void main(String[] args) {
        exercise509 e = new exercise509();
        int fib = e.fib(4);
        System.out.println(fib);
    }
}
