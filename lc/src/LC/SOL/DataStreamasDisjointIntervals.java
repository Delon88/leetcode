package LC.SOL;

import LC.DS.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataStreamasDisjointIntervals {
    class SummaryRanges {

        TreeMap<Integer,Integer> map;
        /** Initialize your data structure here. */
        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            if ( map.containsKey(val) ) return;
            Map.Entry<Integer,Integer> floor = map.floorEntry(val);
            Map.Entry<Integer,Integer> ceil = map.ceilingEntry(val);
            // case
            if ( floor != null && ceil != null && floor.getValue() + 1 == val && ceil.getKey() - 1 == val) {
                map.remove(floor.getKey()); map.remove(ceil.getKey());
                map.put(floor.getKey(), ceil.getValue());
            } else if ( floor != null && floor.getValue() + 1 >= val ) {
                map.put(floor.getKey(), Math.max(floor.getValue(), val));
            } else if ( ceil != null && ceil.getKey() - 1 == val) {
                map.remove(ceil.getKey());
                map.put(val, ceil.getValue());
            } else {
                map.put(val, val);
            }
        }

        public int[][] getIntervals() {
            int[][] ret = new int[map.size()][]; int i = 0;
            for ( Map.Entry<Integer,Integer> in : map.entrySet()) {
                ret[i++] = new int[]{in.getKey(), in.getValue()};
            }
            return ret;
        }
    }
}
