package LC.SOL;

public class LexicographicallySmallestEquivalentString {
    class Solution {

        int[] id;

        public String smallestEquivalentString(String A, String B, String S) {
            id = new int[26];
            for (int i = 0; i < 26; i++) id[i] = i;
            for (int i = 0; i < A.length(); i++) {
                union(A.charAt(i) - 'a', B.charAt(i) - 'a');
            }
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                int ri = find(S.charAt(i) - 'a');
                b.append((char) (ri + 'a'));
            }
            return b.toString();
        }

        void union(int i, int j) {
            int ri = find(i);
            int rj = find(j);
            if (ri <= rj) {
                id[rj] = ri;
            } else {
                id[ri] = rj;
            }
        }

        int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
