package LC.SOL;

public class MonotoneIncreasingDigits {
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            char[] n = Integer.toString(N).toCharArray();
            int i = 0;
            for (i = 0; i < n.length - 1; i++) {
                if (n[i] > n[i + 1]) {
                    char tmp = n[i];
                    while (i >= 0 && tmp == n[i]) {
                        i--;
                    }
                    i++;
                    n[i]--;
                    break;
                }
            }
            i++;
            for (; i < n.length; i++) {
                n[i] = '9';
            }
            return Integer.parseInt(new String(n));
        }
    }
}
