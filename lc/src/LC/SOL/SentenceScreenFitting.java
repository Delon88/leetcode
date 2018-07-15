package LC.SOL;

public class SentenceScreenFitting {

    public class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            String s = String.join(" ", sentence) + " ";
            int start = 0 , n = s.length();
            for ( int i = 0 ; i < rows ; i++) {
                start += cols;
                if ( s.charAt( start % n ) == ' ') {
                    start++;
                } else {
                    while ( start > 0 && ( s.charAt((start -1) % n) != ' ')) {
                        start--;
                    }
                }
            }
            return start / n ;
        }
    }

}
