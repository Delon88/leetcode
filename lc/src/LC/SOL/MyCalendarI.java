package LC.SOL;


import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {
    class MyCalendar {
        TreeMap<Integer,Integer> map;
        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            // check if overlap
            Map.Entry<Integer,Integer> floor = map.floorEntry(start);
            if ( floor != null && floor.getValue() > start) return false;
            Map.Entry<Integer,Integer> ceil = map.ceilingEntry(start);
            if ( ceil != null && ceil.getKey() < end ) return false;
            map.put(start, end);
            return true;
        }
    }
}
