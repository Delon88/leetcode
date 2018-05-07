package LC.SOL;

public class ReverseWordsinaStringII {
    class Solution {
        public void reverseWords(char[] str) {
            int n = str.length;
            reverse(str, 0, n - 1);
            int j = 0 ;
            for (int i = 0; i < n; i++) {
                if (str[i] == ' ') {
                    reverse(str, j, i - 1);
                    j = i + 1;
                }
            }
            reverse(str, j , n -1 );
        }

        void reverse(char[] str, int i, int j) {
            for (; i < j; i++, j--) {
                char tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }
        }
    }
}
