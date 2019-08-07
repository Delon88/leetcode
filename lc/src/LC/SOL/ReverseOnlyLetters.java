package LC.SOL;

public class ReverseOnlyLetters {
    class Solution {
        public String reverseOnlyLetters(String S) {
            int i = 0, j = S.length() - 1;
            char[] arr = S.toCharArray();
            while (i < j) {
                while ( i < j && !Character.isLetter(S.charAt(i))) i++;
                while ( i < j && !Character.isLetter(S.charAt(j))) j--;
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            return new String(arr);
        }
    }
}
