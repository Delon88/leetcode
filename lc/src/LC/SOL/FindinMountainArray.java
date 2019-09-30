package LC.SOL;

public class FindinMountainArray {
    class Solution {
        public int findInMountainArray(int target, MountainArray A) {
            int n = A.length(), l = 0, r = n -1 , m , peak = 0;
            while ( l < r) {
                m = ( l + r ) / 2;
                if ( A.get(m) >= A.get(m + 1)) r = m;
                else l = m + 1;
            }
            peak = l;
            l = 0;
            r = peak;
            while ( l <= r ) {
                m = ( l + r ) / 2;
                if ( A.get(m) > target) r = m - 1;
                else if ( A.get(m) < target) l = m + 1;
                else return m;
            }
            l = peak;
            r = n - 1;
            while ( l <= r ) {
                m = ( l + r ) / 2;
                if ( A.get(m) > target ) l = m + 1;
                else if ( A.get(m) < target ) r = m - 1;
                else return m;
            }
            return -1;
        }
    }

    interface MountainArray {
        public int get(int index);
        public int length();
    }
}

