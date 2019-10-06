package LC.SOL;

public class ArmstrongNumber {
    class Solution {
        public boolean isArmstrong(int N) {
            char[] a = Integer.toString(N).toCharArray();
            int r = 0;
            for (int i = 0; i < a.length; i++) {
                r += (int) Math.pow((a[i] - '0'), a.length);
            }
            return r == N ;
        }
    }
}
