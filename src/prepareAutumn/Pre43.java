package prepareAutumn;

import java.io.Reader;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-03 22:29
 */
public class Pre43 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String ans = "0";
        int m = num1.length();
        int n = num2.length();
        for (int i = n - 1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; j--){
                sb.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--){
                int x = num1.charAt(j) - '0';
                int product =  x * y + add;
                sb.append(product % 10);
                add = product / 10;
            }
            if (add != 0){
                sb.append(add % 10);
            }
            ans = addString(ans, sb.reverse().toString());
        }
        return ans;
    }

    private String addString(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0){
            int x = i >= 0 ?  num1.charAt(i) - '0' : 0;
            int y = j >= 0 ?  num1.charAt(j) - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
       return sb.reverse().toString();
    }
}
