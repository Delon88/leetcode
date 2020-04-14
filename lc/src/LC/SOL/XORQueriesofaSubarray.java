package LC.SOL;

public class XORQueriesofaSubarray {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = arr.length;
            int[] prefix = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = arr[i] ^ prefix[i];
            }
            int[] ret = new int[queries.length];
            for ( int i = 0 ; i < queries.length ; i++) {
                ret[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
            }
            return ret;
        }
    }
}
