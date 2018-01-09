package LC.SOL;

import java.util.TreeMap;

public class MyCalendarIII {
    class MyCalendarThree {


        private TreeMap<Integer, Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<>();
        }


        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int max = 0;
            int con = 0;
            for (int v : map.values()) {
                con += v;
                max = Math.max(max, con);
            }
            return max;
        }
    }

}
