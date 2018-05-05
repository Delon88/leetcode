package LC.SOL;

public class CompareVersionNumbers {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int i = 0 ;
            for ( ; i < v1.length && i < v2.length; i++) {
                int n1 = Integer.parseInt(v1[i]);
                int n2 = Integer.parseInt(v2[i]);
                if ( n1 > n2 ) return 1;
                else if ( n1 < n2 ) return -1;
            }

            String[] remain = v1.length > v2.length ? v1 : v2;
            for ( ; i < remain.length ; i++) {
                int n = Integer.parseInt(remain[i]);
                if ( n != 0 ) {
                    return v1.length > v2.length ? 1 : -1;
                }
            }
            return 0;
        }
    }
}
