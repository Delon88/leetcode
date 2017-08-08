package LC.SOL;

public class DetectCapital {
    public class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.length() == 0) return false;
            if (word.length() == 1) return true;
            int n = word.length();
            boolean firstUpper = Character.isUpperCase(word.charAt(0)) ? true : false;
            int lower = 0, upper = 0;
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    upper++;
                } else {
                    lower++;
                }
            }

            if (firstUpper) {
                if (upper == n - 1 || lower == n - 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (lower == n - 1) return true;
                else return false;
            }
        }
    }
}
