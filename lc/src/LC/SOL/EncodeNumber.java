package LC.SOL;

public class EncodeNumber {
    class Solution {
        //  0 -> ""
        //  1 -> 0
        // 10 -> 01
        // 11 -> 00
        // 100 -> 01
        // 101 -> 010
        // 110 -> 011
        // 111 -> 000
        public String encode(int num) {
            return Integer.toBinaryString(num + 1).substring(1);
        }
    }
}
