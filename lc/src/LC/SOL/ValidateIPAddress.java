package LC.SOL;

import java.util.regex.Pattern;

public class ValidateIPAddress {
    static class Solution {

        Pattern ipv4 = Pattern.compile("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");

        Pattern ipv6 = Pattern.compile("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})");

        public String validIPAddress(String IP) {
            if (ipv4.matcher(IP).matches()) {
                return "IPv4";
            }
            if (ipv6.matcher(IP).matches()) {
                return "IPv6";
            }
            return "Neither";
//            if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))return "IPv4";
//            if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))return "IPv6";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validIPAddress("249.248.247.246"));
    }
}
