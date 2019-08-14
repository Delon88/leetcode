package LC.SOL;

public class ThreeEqualParts {
    class Solution {
        public int[] threeEqualParts(int[] A) {
            int ones = 0, n = A.length;
            for ( int i : A) ones += i;
            if ( ones == 0 ) return new int[]{0 , n -1};
            if ( ones % 3 != 0 ) return new int[]{-1, -1};
            int k = ones / 3;
            int i = 0;
            for ( ; i < n; i++) {
                if ( A[i] == 1) break;
            }
            int first = i;
            int count = 0;
            for ( i = 0; i < n ;i++) {
                if ( A[i] == 1) count++;
                if ( count == k + 1) break;
            }
            int second =  i;
            count = 0;
            for ( i = 0 ; i < n ;i++) {
                if (A[i] == 1) count++;
                if ( count == 2 * k  +1) break;
            }
            int third = i;
            // check if it's valid
            while  (third < n && A[first] == A[second] && A[second] == A[third]) {
                first++; second++;third++;
            }
            if ( third == n ) return new int[]{first - 1, second };
            else return new int[]{-1 , -1};
        }
    }
}
