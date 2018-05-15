package LC.SOL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElementII {
    static class Solution {

        class Node {
            public int ele;
            public int count;
        }
        public List<Integer> majorityElement(int[] nums) {
            Node[] a = new Node[2];
            a[0] = new Node();
            a[1] = new Node();
            for ( int i = 0 ;i < nums.length ; i++) {
                int j = 0;
                for ( ; j < 2 ; j++) {
                    if ( a[j].ele == nums[i]) {
                        a[j].count += 1;
                        break;
                    }
                }
                // if not in the array, find if there is available slot
                if ( j == 2 ) {
                    int l = 0;
                    for ( ; l < 2 ; l++) {
                        if ( a[l].count == 0 ) {
                            a[l].ele = nums[i];
                            a[l].count = 1;
                            break;
                        }
                    }
                    // no available slot, minus 1 to all elements
                    if ( l == 2 ) {
                        for ( int k = 0 ;  k < 2 ; k++) {
                            a[k].count--;
                        }
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for ( int i = 0 ;i < 2 ; i++) {
                int ac = 0;
                for ( int j = 0 ;  j < nums.length; j++) {
                    if ( nums[j] == a[i].ele ) {
                        ac++;
                    }
                }
                if ( ac > nums.length / 3 ) {
                    set.add(a[i].ele);
                }
            }
            return new ArrayList<>(set);
        }
    }

    public static void main(String[] args) {
        int[] n = {1,2,3};
        System.out.println(new Solution().majorityElement(n));
    }
}
