package LC.SOL;

public class BoldWordsinString {
    class Solution {
        public String boldWords(String[] words, String S) {
            boolean[] bold = new boolean[S.length()];
            for (int i = 0; i < S.length(); i++) {
                for (String w : words) {
                    if (S.startsWith(w, i)) {
                        for (int j = 0; j < w.length(); j++) {
                            bold[i + j] = true;
                        }
                    }
                }
            }

            int i = 0;
            StringBuilder b = new StringBuilder();
            while (i < S.length()) {
                if (bold[i]) {
                    b.append("<b>");
                    while (i < S.length() && bold[i]) {
                        b.append(S.charAt(i));
                        i++;
                    }
                    b.append("</b>");
                } else {
                    b.append(S.charAt(i));
                    i++;
                }
            }
            return b.toString();
        }
    }
}
