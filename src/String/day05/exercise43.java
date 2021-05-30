package String.day05;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-23 15:22
 */

public class exercise43 {
    //做乘法
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--)
        {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--)
            {
                int y = num2.charAt(j) - '0';
                ans[ i + j + 1]  += x * y;
            }
        }
        for (int i = m + n - 1; i>0; i--)
        {
            ans[i - 1] += ans[i] / 10;
            ans[i] = ans[i] % 10;
        }
        int index = ans[0] == 0 ? 1: 0;
        StringBuilder res = new StringBuilder();
        while (index < m + n)
        {
            res.append(ans[index]);
            index++;
        }
        return res.toString();
    }
    //做加法
    public String multiply1(String num1, String num2)
    {
        if ("0".equals(num1)||"0".equals(num2))
        {return "0";}
        String ans = "0";
        int m = num1.length();
        int n = num2.length();
        for (int i = n - 1; i >= 0; i--)
        {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j >= i; j--)
            {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j>= 0; j--)
            {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0)
            {
                curr.append( add % 10);
            }
            ans = addString(ans, curr.reverse().toString());
        }
        return ans;
    }

    private String addString(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while ( i >= 0 || j >= 0 || add != 0)
        {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append( result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        exercise43 e = new exercise43();
        String multiply = e.multiply(num1, num2);
        System.out.println(multiply);
    }
}
