package String.day15;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-13 9:33
 */
public class exercise537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] x = num1.split("\\+", -1);
        String[] y = num2.split("\\+", -1);;

        int pureNum = Integer.parseInt(x[0]) * Integer.parseInt(y[0]);
        int leftI = Integer.parseInt(x[0]) * Integer.parseInt(y[1].substring(0,y[1].length() - 1));
        int rightI = Integer.parseInt(x[1].substring(0,x[1].length() - 1)) * Integer.parseInt(y[0]);
        int allI = Integer.parseInt(x[1].substring(0, x[1].length() - 1)) * Integer.parseInt(y[1].substring(0,y[1].length() - 1));

        int noPre = leftI + rightI;
        pureNum = pureNum - allI;
        return pureNum + "+" + noPre + "i";
    }
}
