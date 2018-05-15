package LC.SOL;

public class FirstBadVersion {
    class Solution {

        boolean isBadVersion(int version) {
            return false;
        }

        public int firstBadVersion(int n) {
            int start = 1, end = n, mid = 0;
            while (start < end) {
                mid = start + (end - start) / 2;
                if ( isBadVersion(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            if ( !isBadVersion(start) ) return -1;
            return start;
        }
    }
}
