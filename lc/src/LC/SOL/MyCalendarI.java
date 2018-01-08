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
            Map.Entry<Integer,Integer> s = map.floorEntry(start);
            Map.Entry<Integer,Integer> e = map.ceilingEntry(end);
            if ( s != null &&  start < s.getValue() ) {
                return false;
            }
            if ( e != null && end > e.getKey()) {
                return false;
            }
            map.put(start , end);
            return true;
        }
    }
}
