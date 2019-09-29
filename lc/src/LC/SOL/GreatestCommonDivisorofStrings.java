package LC.SOL;

public class GreatestCommonDivisorofStrings {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);
            if (!str1.startsWith(str2)) return "";
            else if (str2.isEmpty()) return str1;
            else return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}
