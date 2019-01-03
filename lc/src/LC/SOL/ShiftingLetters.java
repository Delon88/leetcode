package LC.SOL;

public class ShiftingLetters {
    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            for (int i = shifts.length - 2; i >= 0; i--) shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
            StringBuilder b = new StringBuilder();
            for ( int i = 0 ; i <  S.length() ; i++) {
                b.append((char) (((S.charAt(i) - 'a') + shifts[i]) % 26 + 'a') ) ;
            }
            return b.toString();
        }
    }
}
