package LC.SOL;

import java.util.HashMap;
import java.util.Map;

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
                if ( value - n == n ) {
                    return map.get(n) >= 2;
                } else {
                    return map.containsKey(value - n);
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
