package LC.SOL;

public class StringWithoutAAAorBBB {
    class Solution {
        public String strWithout3a3b(int A, int B) {
            StringBuilder bu = new StringBuilder(A + B);
            char a = 'a', b = 'b';
            int i = A, j = B;
            if ( A < B ) {a = 'b'; b = 'a'; i = B; j = A;}
            while (i > 0) {
                bu.append(a);
                i--;
                if (i > j) {
                    bu.append(a);
                    i--;
                }
                if (j > 0) {
                    bu.append(b);
                    j--;
                }
            }
            return bu.toString();
        }
    }
}
