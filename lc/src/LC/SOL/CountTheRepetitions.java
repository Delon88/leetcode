package LC.SOL;

public class CountTheRepetitions {
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int s2index = 0, repeat = 0 ;
            for ( int i = 0 ; i < n1 ; i++) {
                for (int j = 0 ; j < s1.length() ; j++) {
                    if ( s1.charAt(j) == s2.charAt(s2index)) {
                        s2index++;
                    }
                    if ( s2index == s2.length()) {repeat++; s2index = 0;}
                }
            }
            return repeat / n2;
        }
    }
}
