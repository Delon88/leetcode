package LC.SOL;

public class SingleNumberII {
    class Solution {
        public int singleNumber1(int[] nums) {
            int ones = 0, twos = 0;
            for (int n : nums) {
                ones = (ones ^ n) & ~twos;
                twos = (twos ^ n) & ~ones;
            }
            return ones;
        }

    }

    class Solution1 {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for ( int n : nums) {
                    count += ( ( n >> i) & 1 ) == 1 ? 1: 0;
                    count %= 3;
                }
                if ( count == 1 ) {
                    ans |= ( 1 << i);
                }
            }
            return ans;
        }
    }
}
