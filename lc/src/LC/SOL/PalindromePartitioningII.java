package LC.SOL;

public class PalindromePartitioningII {
    class Solution {
        public int minCut(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            char[] a = s.toCharArray();
            int[] cut = new int[n + 1];
            for (int i = 0; i < cut.length; i++) {
                cut[i] = i - 1;
            }
            for (int i = 0; i < n; i++) {
                for ( int start= i , end = i ; start >= 0 && end < n && a[start] == a[end]; start--, end++) {
                    cut[end + 1] = Math.min(cut[end + 1] , cut[start] + 1);
                }
                for ( int start = i , end = i + 1 ; start >= 0 && end < n && a[start] == a[end] ; start--, end++) {
                    cut[end + 1] = Math.min(cut[end + 1], cut[start] + 1);
                }
            }
            return cut[n];
        }
    }
}
