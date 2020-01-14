package LC.SOL;

public class MaximumScoreWordsFormedbyLetters {
    class Solution {
        // l * w
        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            int[] count = new int[score.length];
            for ( char c : letters) count[c - 'a']++;
            return dfs(words, count, score , 0);
        }

        int dfs(String[] words,int[] count, int[] score, int level) {
            int max = 0;
            for ( int i = level ; i < words.length ; i++) {
                // add cur word
                int tmp = 0;
                boolean isValid = true;
                for ( char c : words[i].toCharArray()) {
                    count[c - 'a']--;
                    tmp += score[ c- 'a'];
                    if ( count[c - 'a'] < 0) isValid = false;
                }
                if ( isValid) {
                    tmp += dfs(words, count, score, i + 1);
                    max = Math.max(tmp ,  max);
                }
                // backtrack;
                for ( char c : words[i].toCharArray()) {
                    count[c - 'a']++;
                }
            }
            return max;
        }
    }
}
