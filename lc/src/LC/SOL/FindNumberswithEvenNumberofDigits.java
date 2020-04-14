package LC.SOL;

public class FindNumberswithEvenNumberofDigits {
    class Solution {
        public int findNumbers(int[] nums) {
            int count = 0;
            for (int n : nums) {
                int d = 0;
                while ( n != 0 ) {
                    d++;
                    n /= 10;
                }
                count += d % 2 == 0 ? 1: 0;
            }
            return count;
        }
    }
}
