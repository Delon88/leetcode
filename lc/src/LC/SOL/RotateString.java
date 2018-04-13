package LC.SOL;

public class RotateString {
    class Solution {
        public boolean rotateString(String A, String B) {
            if ( A.length() != B.length() ) return false;
            return (A + A).contains(B);
        }
    }
}
