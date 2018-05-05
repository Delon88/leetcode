package LC.SOL;

public class SingleNumberII {
    class Solution {
        public int singleNumber1(int[] nums) {
            int ones = 0, twos = 0;
            for ( int n : nums) {
                ones = ( ones ^ n ) & ~twos;
                twos = ( twos ^ n ) & ~ones;
            }
            return ones;
        }


        public int singleNumber(int[] nums) {
            return solve(nums, 3);
        }

        int solve(int[] nums, int K) {
            int[] c = new int[31];
            for ( int n : nums) {
                for ( int i = 0 ; i < 31;  i++) {
                    c[i] += (n | (1 << i)) > 0 ? 1 : 0;
                    if ( c[i] == K ) c[i] = 0;
                }
            }
            StringBuilder b = new StringBuilder();
            for ( int i = 30 ; i >= 0 ; i--) {
                b.append(c[i]);
            }
            return Integer.parseInt(b.toString() , 2);
        }

    }
}
