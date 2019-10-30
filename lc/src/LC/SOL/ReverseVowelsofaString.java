package LC.SOL;

public class ReverseVowelsofaString {
    class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) return s;
            String vows = "aeiouAEIOU";
            char[] chars = s.toCharArray();
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                while (start < end && !vows.contains(chars[start] + "")) {
                    start++;
                }
                while (start < end && !vows.contains(chars[end] + "")) {
                    end--;
                }
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
            return new String(chars);
        }
    }
}
