package Arrays.day01;

/**
 * @author sunchuanjia
 * @Description  #1513.仅含1的字串数
 * @create 2021-03-06 14:01
 */
public class exercise1513 {
    public int numSub(String s) {
        final long MODNUMBER = 1000000007;
        long OneCount=0, result=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(('0') == c ){
                result += OneCount*(OneCount+1)/2;
                OneCount = 0;
            }else{
                OneCount++;
            }
        }
        result += OneCount*(OneCount+1)/2;
        return (int) (result%MODNUMBER);
    }

    public static void main(String[] args) {
        exercise1513 e = new exercise1513();
        int i = e.numSub("111111");
        System.out.println(i);
    }
}
