package LC.SOL;


public class NumberofLongestIncreasingSubsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, maxLen = 0, maxCount = 0;
            int[] len = new int[n];
            int[] count = new int[n];
            for ( int i = 0 ; i < n ; i++) {
                len[i] = count[i] = 1;
                for ( int j = 0 ; j <  i ; j++) {
                    if ( nums[i] > nums[j] ) {
                        if ( len[i] < len[j] + 1) {
                            len[i] = len[j] + 1;
                            count[i] = count[j];
                        } else if ( len[i] == len[j] + 1) {
                            count[i] += count[j];
                        }
                    }
                }
                if ( len[i] == maxLen) maxCount += count[i];
                else  if ( len[i] > maxLen) {
                    maxLen = len[i];
                    maxCount = count[i];
                }
            }
            return maxCount;
        }
    }
}
