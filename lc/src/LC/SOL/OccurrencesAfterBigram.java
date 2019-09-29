package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] words = text.split(" ");
            List<String> l = new ArrayList<>();
            for (int i = 2; i < words.length; i++) {
                if (words[i - 2].equals(first) && words[i - 1].equals(second)) l.add(words[i]);
            }
            String[] ret = new String[l.size()];
            for (int i = 0; i < ret.length; i++) ret[i] = l.get(i);
            return ret;
        }
    }
}
