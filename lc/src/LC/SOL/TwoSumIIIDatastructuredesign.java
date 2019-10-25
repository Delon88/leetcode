package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumIIIDatastructuredesign {
    class TwoSum {

        Map<Integer,Integer> map;
        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for ( int n : map.keySet()) {
                int diff = value - n;
                if ( map.containsKey(diff) && ( diff != n || map.get(diff) >= 2 )) return true;
            }
            return false;
        }
    }

    class Solution {
        class TwoSum {
            /** Initialize your data structure here. */
            Set<Integer> num = new HashSet<>();
            Set<Integer> sum = new HashSet<>();

            public TwoSum() {

            }

            /** Add the number to an internal data structure.. */
            public void add(int number) {
                for ( int n : num) {
                    sum.add(n + number);
                }
                num.add(number);
            }

            /** Find if there exists any pair of numbers which sum is equal to the value. */
            public boolean find(int value) {
                return sum.contains(value);
            }
        }
    }


/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
