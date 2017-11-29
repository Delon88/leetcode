package LC.SOL;

public class BinaryNumberwithAlternatingBits {
    class Solution {

        public boolean hasAlternatingBits(int n) {
            n = n ^ (n >> 2);
            return (n & (n - 1)) == 0;
        }
//        public boolean hasAlternatingBits(int n) {
//            boolean al = false;
//            if ((n & 1) == 1) al = true;
//            while (n > 0) {
//                if (al) {
//                    if ((n & 1) == 0) return false;
//                } else {
//                    if ((n & 1) == 1) return false;
//                }
//                al = !al;
//                n = n >>> 1;
//            }
//            return true;
//        }
    }
}
