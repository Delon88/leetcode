package LC.SOL;

public class SmallestSubsequenceofDistinctCharacters {
    class Solution {
        public String smallestSubsequence(String text) {
            if ( text.length() == 0 ) return "";
            int[] cnt= new int[26];
            for ( int i = 0 ; i < text.length(); i++) cnt[text.charAt(i) - 'a']++;
            int pos = 0;
            for ( int i = 0  ;i < text.length(); i++) {
                if (text.charAt(pos) > text.charAt(i)) pos = i;
                if ( --cnt[text.charAt(i) - 'a'] == 0) break;
            }
            return text.charAt(pos) + smallestSubsequence(text.substring(pos + 1).replaceAll(text.charAt(pos) + "", ""));
        }
    }
}
