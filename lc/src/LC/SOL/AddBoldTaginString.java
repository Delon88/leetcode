package LC.SOL;



public class AddBoldTaginString {
    class Solution {
        public String addBoldTag(String s, String[] dict) {
            boolean[] e = new boolean[s.length()];
            for ( int i = 0 , end = 0 ; i < s.length(); i++) {
                for ( String word: dict) {
                    if ( s.startsWith(word, i )) {
                        end = Math.max( end , i + word.length());
                    }
                }
                e[i] = end > i ;
            }

            StringBuilder builder = new StringBuilder();
            for ( int i = 0 ; i < s.length() ; i++) {
                if ( !e[i]) {
                    builder.append(s.charAt(i));
                } else {
                    builder.append("<b>");
                    while ( i < s.length() && e[i] ) {
                        builder.append(s.charAt(i));
                        i++;
                    }
                    builder.append("</b>");
                    i--;
                }
            }
            return builder.toString();
        }
    }
}
