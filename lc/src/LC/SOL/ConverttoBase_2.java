package LC.SOL;

public class ConverttoBase_2 {
    class Solution {
        public String baseNeg2(int N) {
            String ret = "";
            while (N != 0) {
                int rem = N % -2;
                N /= -2;
                if (rem < 0) {
                    rem += Math.abs(-2);
                    N++;
                }
                ret = rem + ret;
            }
            return ret == "" ? "0" : ret;
        }
    }
}
