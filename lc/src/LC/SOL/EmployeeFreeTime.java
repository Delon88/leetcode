package LC.SOL;

import LC.DS.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmployeeFreeTime {
    class Solution {
        //        Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//        Output: [[3,4]]
//        Explanation:
//        There are a total of three employees, and all common
//        free time intervals would be [-inf, 1], [3, 4], [10, inf].
//        We discard any intervals that contain inf as they aren't finite.
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<Interval> list = new ArrayList<>();
            List<Interval> free = new ArrayList<>();
            for (List<Interval> s : schedule) {
                list.addAll(s);
            }
            Collections.sort(list, (a, b) -> a.start - b.start);
            Interval tmp = list.get(0);
            for ( int i = 1 ; i < list.size() ; i++) {
                Interval in =  list.get(i);
                if ( in.start > tmp.end ) {
                    free.add(new Interval(tmp.end, in.start));
                    tmp = in;
                } else {
                    tmp.end = Math.max(in.end, tmp.end);
                }
            }
            return free;
        }
    }
}
