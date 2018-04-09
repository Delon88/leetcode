package LC.SOL;

import java.util.Arrays;

public class MagicalString {
    static class Solution {
        public int magicalString(int n) {
            if ( n == 0) return 0;
            if (n <= 2) return 1;
            int[] a = new int[n + 2];
            a[0] = 1;
            a[1] = 2;
            a[2] = 2;
            int i = 2, j = 2;
            while (i < n) {
                if (a[j] == 2) {
                    if (a[i] == 2) {
                        a[++i] = 1;
                        a[++i] = 1;
                    } else {
                        a[++i] = 2;
                        a[++i] = 2;
                    }
                    j++;
                } else {
                    if (a[i] == 2) {
                        a[++i] = 1;
                    } else {
                        a[++i] = 2;
                    }
                    j++;
                }
            }
            int count = 0;
            for (int k = 0; k < n; k++) {
                if (a[k] == 1) count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        new Solution().magicalString(3);
    }
}