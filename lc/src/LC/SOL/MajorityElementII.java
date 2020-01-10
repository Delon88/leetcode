package LC.SOL;

import java.util.*;

public class MajorityElementII {
    static class Solution {

        public List<Integer> majorityElement(int[] nums) {
            int len = nums.length,  k = 3 ;
            List<Integer> ret = new ArrayList<>();
            if ( len == 0 ) return ret;
            int[] count = new int[k - 1], ele = new int[k - 1];
            for ( int n : nums ) {
                boolean placed = false;
                // find if it's already major
                for ( int i = 0 ; i < k - 1  ; i++) {
                    if ( ele[i] == n ) {
                        count[i]++; placed = true; break;
                    }
                }
                if ( placed ) continue;
                // find if there is available slot
                for ( int i = 0 ; i < k - 1; i++) {
                    if ( count[i] == 0 ) {
                        count[i]++;ele[i] = n;placed = true;break;
                    }
                }
                if ( placed ) continue;
                // minus 1 for all ele
                for ( int i = 0 ; i < k - 1; i++) count[i]--;
            }
            Arrays.fill(count, 0 );
            for ( int n : nums ) {
                for ( int i = 0 ; i < k - 1 ; i++) {
                    if ( n == ele[i]) {
                        count[i]++;break;
                    }
                }
            }
            for ( int i = 0 ; i < k - 1 ; i++) {
                if ( count[i] > len / k ) ret.add(ele[i]);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 3};
        System.out.println(new Solution().majorityElement(n));
    }
}
