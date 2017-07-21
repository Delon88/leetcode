package LC.SOL;

public class HammingDistance {
    public class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount( x ^ y);
        }
    }
}
