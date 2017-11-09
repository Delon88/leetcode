package LC.SOL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            Set<String> set = new HashSet<>();
            for (String word : dict) {
                set.add(word);
            }
            String[] words = sentence.split("\\s");
            StringBuilder b = new StringBuilder();
            for (String word : words) {
                boolean hasPre = false;
                for (int i = 0; i < word.length(); i++) {
                    String pre = word.substring(0, i + 1);
                    if (set.contains(pre)) {
                        b.append(pre).append(' ');
                        hasPre = true;
                        break;
                    }
                }
                if (!hasPre) b.append(word).append(' ');
            }
            if (b.length() != 0 && b.charAt(b.length() - 1) == ' ') b.deleteCharAt(b.length() - 1);
            return b.toString();
        }
    }
}
