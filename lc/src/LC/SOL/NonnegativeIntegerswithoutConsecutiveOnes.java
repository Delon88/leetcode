package LC.SOL;

public class NonnegativeIntegerswithoutConsecutiveOnes {
    static class Solution {
        //        Given a positive integer n, find the number of
//        non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.
        public int findIntegers(int num) {
            String binary = Integer.toBinaryString(num);
            int n = binary.length();
            int[] ones = new int[n];
            int[] zeros = new int[n];
            zeros[0] = 1;
            ones[0] = 1;
            for (int i = 0; i < n - 1; i++) {
                ones[i + 1]  = zeros[i];
                zeros[i + 1] = zeros[i] + ones[i];
            }
            int ret = ones[n - 1] + zeros[n - 1];
            for (int i = 0; i < n - 1; i++) {
                if (binary.charAt(i) == '1' && binary.charAt(i + 1) == '1') {
                    break;
                }
                if (binary.charAt(i) == '0' && binary.charAt(i + 1) == '0') {
                    ret -= ones[n - i - 2];
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIntegers(8));
    }

}
