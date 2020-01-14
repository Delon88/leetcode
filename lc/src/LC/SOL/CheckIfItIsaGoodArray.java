package LC.SOL;

public class CheckIfItIsaGoodArray {
    class Solution {
        public boolean isGoodArray(int[] nums) {
            int x = nums[0];
            for ( int a : nums) {
                x = gcd(x , a);
            }
            return x == 1;
        }

        int gcd(int x, int y) {
            if ( y == 0) return x;
            else return gcd( y , x % y);
        }
    }
}
