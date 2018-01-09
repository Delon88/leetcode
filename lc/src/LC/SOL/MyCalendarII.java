package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {
    class MyCalendarTwo {
        private List<int[]> books;

        public MyCalendarTwo() {
            books = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            MyCalendar c = new MyCalendar();
            for (int[] b : books) {
                // check overlap
                if (Math.max(start, b[0]) < Math.min(end, b[1])) {
                    if (!c.book(Math.max(start, b[0]), Math.min(end, b[1]))) return false;
                }
            }
            books.add(new int[]{start, end});
            return true;
        }

        class MyCalendar {
            TreeMap<Integer, Integer> map;

            public MyCalendar() {
                map = new TreeMap<>();
            }

            public boolean book(int start, int end) {
                // check if overlap
                Map.Entry<Integer, Integer> floor = map.floorEntry(start);
                if (floor != null && floor.getValue() > start) return false;
                Map.Entry<Integer, Integer> ceil = map.ceilingEntry(start);
                if (ceil != null && ceil.getKey() < end) return false;
                map.put(start, end);
                return true;
            }
        }
    }
}
