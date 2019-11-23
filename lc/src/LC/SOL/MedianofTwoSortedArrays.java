package LC.SOL;

public class MedianofTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int i = 0, j = 0, istart = 0, iend = m;
            double maxLeft = 0, minRight = 0;
            while (istart <= iend) {
                i = (istart + iend) / 2;
                j = (m + n + 1) / 2 - i;
                if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                    istart = i + 1;
                } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                    iend = i - 1;
                } else {
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = (double) Math.max(nums1[i - 1] ,nums2[j - 1]);
                    }
                    break;
                }
            }
            if ( ( m  + n ) % 2 == 1) return maxLeft;
            if ( i == m ) { minRight = nums2[j] ;}
            else if ( j == n ) { minRight = nums1[i];}
            else { minRight = Math.min(nums1[i] , nums2[j]);}

            return ( maxLeft + minRight) / 2.0d;
        }
    }
}
