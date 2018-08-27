package LC.SOL;

public class MaskingPersonalInformation {
    class Solution {
        String[] country = {"", "+*-", "+**-", "+***-"};

        public String maskPII(String S) {
            int index = S.indexOf("@");
            if (index != -1) {
                S = S.toLowerCase();
                return (S.charAt(0) + "*****" + S.substring(index - 1));
            } else {
                S = S.replaceAll("[^0-9]", "");
                return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
            }
        }
    }
}
