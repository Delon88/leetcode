package LC.SOL;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class KeyboardRow {
    public class Solution {
        public String[] findWords(String[] words) {
            Pattern p = Pattern.compile("[qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+");
            List<String> list = new ArrayList<>();
            for ( String w : words) {
                if ( p.matcher(w.toLowerCase()).matches() ) list.add(w);
            }
            String[] ret = new String[list.size()];
            for ( int i = 0 ; i < list.size() ; i++) {
                ret[i] = list.get(i);
            }
            return ret;
        }
    }
}
