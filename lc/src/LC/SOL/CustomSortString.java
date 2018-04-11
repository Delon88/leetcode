package LC.SOL;


public class CustomSortString {
    class Solution {
        public String customSortString(String S, String T) {
            int[] tA = new int[26];
            for (int i = 0; i < T.length(); i++) {
                tA[T.charAt(i) - 'a']++;
            }
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (tA[S.charAt(i) - 'a'] > 0) {
                    for (int j = 0; j < tA[S.charAt(i) - 'a']; j++) {
                        b.append(S.charAt(i));
                    }
                    tA[S.charAt(i) - 'a'] = 0;
                }
            }
            for (int i = 0; i < T.length(); i++) {
                if (tA[T.charAt(i) - 'a'] > 0 ) b.append(T.charAt(i));
            }
            return b.toString();
        }


    }
}
