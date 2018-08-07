package LC.SOL;

import java.text.SimpleDateFormat;
import java.util.*;

public class DesignLogStorageSystem {
    class LogSystem {
        TreeMap<String,List<Integer>> map;
        Map<String,Integer> index;
        private String min, max;
        public LogSystem() {
            min = "2000:01:01:00:00:00";
            max = "2017:12:31:23:59:59";
            map  = new TreeMap<>();
            index = new HashMap<>();
            index.put("Year", 4);
            index.put("Month", 7);
            index.put("Day", 10);
            index.put("Hour", 13);
            index.put("Minute", 16);
            index.put("Second", 19);
        }

        public void put(int id, String timestamp) {
            if ( !map.containsKey(timestamp)) map.put(timestamp, new ArrayList<>());
            map.get(timestamp).add(id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            int i = index.get(gra);
            List<Integer> ret = new ArrayList<>();
            String start = s.substring(0, i) + min.substring(i), end = e.substring(0, i) + max.substring(i);
            SortedMap<String,List<Integer>> range = map.subMap(start , true, end,   true);
            for ( List<Integer> ids : range.values())   {
                ret.addAll(ids);
            }
            return ret;
        }
    }
}
