package String.day15;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-12 9:36
 */
public class exercise468 {
    //分治
    public String validIPAddress(String IP) {
        if(IP.chars().filter(ch -> ch == '.').count() == 3)
        {
            return validIp4(IP);
        }else if (IP.chars().filter(ch -> ch == ':').count() == 7)
        {
            return validIp6(IP);
        }
        else return "Neither";
    }

    private String validIp4(String ip) {
        String[] nums = ip.split("\\.", -1);
        for (String num : nums)
        {
            if (num.length() == 0 || num.length() > 3) return "Neither";
            if (num.charAt(0) == '0' && num.length() != 1) return "Neither";
            int temp = 0;
            for (char ch : num.toCharArray())
            {
                if (ch - '0' < 0 || ch - '0' > 9) return "Neither";
                temp = temp * 10 + (ch - '0');
            }
            if (temp > 255 || temp < 0) return "Neither";
        }
        return "IPv4";
    }

    private String validIp6(String ip) {
        String[] nums = ip.split(":", -1);
        String indexDigit = "0123456789abcdefABCDEF";
        for (String num : nums)
        {
            if (num.length() == 0 || num.length() > 4) return "Neither";
            for (char ch : num.toCharArray())
            {
                if (indexDigit.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}
