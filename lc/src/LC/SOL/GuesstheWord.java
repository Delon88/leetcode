package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuesstheWord {

    interface Master {
        public int guess(String word) {
        }
    }

    class Solution {
        public void findSecretWord(String[] wordlist, Master master) {
            for ( int i = 0 , m = 0; i < 10 && m < 6 ; i++) {
                String guess = wordlist[new Random().nextInt(wordlist.length)];
                m = master.guess(guess);
                List<String> next = new ArrayList<>();
                for ( String w : wordlist) {
                    if ( match(w , guess) == m ) {
                        next.add(w);
                    }
                }
                wordlist = next.toArray(new String[next.size()]);
            }
        }

        int match(String a, String b) {
            int match = 0 ;
            for ( int i = 0 ; i < a.length(); i++) {
                if ( a.charAt(i) == b.charAt(i)) match++;
            }
            return match;
        }
    }
}
