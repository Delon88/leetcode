package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int start = 0, wordCount = 0, wordLen = 0;
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (wordLen + wordCount + words[i].length() > maxWidth) {
                    StringBuilder b = new StringBuilder();
                    b.append(words[start]);
                    if (wordCount > 1) {
                        int avgSpace = (maxWidth - wordLen) / (wordCount - 1);
                        int leftSpace = (maxWidth - wordLen) % (wordCount - 1);
                        for (int j = start + 1; j < i; j++) {
                            if (leftSpace > 0) {
                                appendSpace(b, avgSpace + 1);
                                leftSpace--;
                            } else {
                                appendSpace(b, avgSpace);
                            }
                            b.append(words[j]);
                        }
                    } else {
                        appendSpace(b, maxWidth - wordLen);
                    }
                    ret.add(b.toString());
                    start = i;
                    wordLen = 0;
                    wordCount = 0;
                }
                wordLen += words[i].length();
                wordCount++;

            }
            StringBuilder b = new StringBuilder();
            b.append(words[start]);
            for ( int i = start + 1 ;  i < words.length ;i++) {
                b.append(' ').append(words[i]);
            }
            appendSpace(b, maxWidth - b.length());
            ret.add(b.toString());
            return ret;
        }

        private void appendSpace(StringBuilder b, int n) {
            for (int i = 0; i < n; i++) {
                b.append(' ');
            }
        }

    }
}
