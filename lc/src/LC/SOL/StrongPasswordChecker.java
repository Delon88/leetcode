package LC.SOL;


public class StrongPasswordChecker {
    public class Solution {
        public int strongPasswordChecker(String s) {
            int res = 0, a = 1, A = 1, d = 1;
            char[] arr = s.toCharArray();
            int[] len = new int[arr.length];
            for ( int i = 0 ;i < arr.length;) {
                char c = arr[i];
                if ( Character.isLowerCase(c)) { a = 0;}
                if ( Character.isUpperCase(c)) { A = 0;}
                if ( Character.isDigit(c)) {d = 0;}
                int j = i;
                while ( i < arr.length && c == arr[i] ) {
                    i++;
                }
                len[j] = i - j;
            }

            int totalMissing = a + A + d;

            if (arr.length < 6) {
                // insert missing ones and insert extras to reach 6
                res += totalMissing + Math.max(0, 6 - arr.length - totalMissing);
            } else {
                int overLen = Math.max(0, arr.length - 20);
                res += overLen;
                // see if deletion fix repeat
                for ( int k = 1 ; k < 3; k++) {
                    for ( int j = 0 ; j < len.length && overLen > 0; j++) {
                        if ( len[j] < 3 || len[j] % 3 != ( k - 1) ) continue;
                        len[j] -= Math.min(overLen, k);
                        overLen -= k;
                    }
                }
                int leftToReplace = 0;
                for ( int i = 0 ; i < arr.length ; i++) {
                    if ( len[i] >= 3 && overLen > 0) {
                        int needDel = len[i] - 2;
                        len[i] -= overLen;
                        overLen-= needDel;
                    }
                    if ( len[i] >= 3 ) leftToReplace += len[i] / 3;
                }
                res += Math.max(totalMissing, leftToReplace);
            }
            return res;
        }
    }
}
