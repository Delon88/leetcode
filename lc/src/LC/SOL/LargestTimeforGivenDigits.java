package LC.SOL;

public class LargestTimeforGivenDigits {
    class Solution {
        public String largestTimeFromDigits(int[] A) {
            String ret = "";
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if ( i == j || i == k || j == k ) continue;
                        String h = "" + A[i] + A[j], m = "" + A[k] + A[ 6 - ( i + j + k)], t = h + ":" + m;
                        if ( h.compareTo("24") < 0 && m.compareTo("60") < 0 && t.compareTo(ret) > 0) ret = t;
                    }
                }
            }
            return ret;
        }
    }
}
