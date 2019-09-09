package LC.SOL;

public class SatisfiabilityofEqualityEquations {
    class Solution {

        int[] uf;

        public boolean equationsPossible(String[] equations) {
            uf = new int[26];
            for (int i = 0; i < 26; i++) uf[i] = i;
            for (String e : equations) {
                if (e.charAt(1) == '=') {
                    int i = e.charAt(0) - 'a', j = e.charAt(e.length() - 1) - 'a';
                    int ri = find(i), rj = find(j);
                    uf[ri] = rj;
                }
            }
            for (String e : equations) {
                if (e.charAt(1) == '!') {
                    int i = e.charAt(0) - 'a', j = e.charAt(e.length() - 1) - 'a';
                    int ri = find(i), rj = find(j);
                    if ( ri == rj) return false;
                }
            }
            return true;
        }

        int find(int i) {
            while (i != uf[i]) {
                uf[i] = uf[uf[i]];
                i = uf[i];
            }
            return i;
        }
    }
}
