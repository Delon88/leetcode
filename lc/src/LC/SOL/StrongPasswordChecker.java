package LC.SOL;

import java.io.CharArrayReader;

public class StrongPasswordChecker {
    public class Solution {
        public int strongPasswordChecker(String s) {
            // case 1 length < 6
            // case 2 length [6. 20]
            // case 3 length > 20;
            int delete = 0, insert = 0;
            char[] a = s.toCharArray();
            if (s.length() > 20) {
                delete = s.length() - 20;
            }
            if (s.length() < 6) {
                insert = s.length() - 6;
            }
            int toDelete = 0, toInsert = 0, toReplace = 0, needUpper = 1, needLower = 1, needDigit = 1;
            for (int l = 0, r = 0; r < s.length(); r++) {
                if (Character.isUpperCase(a[r])) {
                    needUpper = 0;
                }
                if (Character.isLowerCase(a[r])) {
                    needLower = 0;
                }
                if (Character.isDigit(a[r])) {
                    needDigit = 0;
                }
                if (r - l == 2) {
                    if ( a[l] == a[l + 1] && a[l] == a[l + 2]) {
                        if  ( toInsert < insert) {toDelete++; l  = r ;}
                        else { toReplace++; l = r + 1;}
                    } else {
                        l++;
                    }
                }
            }
            if ( s.length() <= 20) return Math.max(insert + toReplace, needUpper + needLower + needDigit);
            toReplace= 0;

        }
    }
}
