package Interview;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-20 14:22
 */
public class T1 {

    public int compress(char[] chars) {
        int n = chars.length;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {

            int j = i + 1;
            char cur = chars[i];
            int count = 1;
            while (j < n && chars[j] == cur){
                j++;
                count++;
            }
            if (count > 1){
                sb.append(cur);
                sb.append(String.valueOf(count));

            }else{
                sb.append(cur);
            }
            i = j - 1;
        }
        System.out.println(sb.toString());
        return sb.toString().toCharArray().length;
    }

    public int compress1(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;

        for (int read = 0; read < n; read++){
            if (read == n - 1 || chars[read] != chars[read + 1]){
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1){
                    int anchor = write;
                    while (num > 0){
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        t1.compress(chars);
    }
}
