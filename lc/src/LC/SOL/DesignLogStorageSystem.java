package LC.SOL;

import java.text.SimpleDateFormat;
import java.util.*;

public class DesignLogStorageSystem {
    class LogSystem {

        TreeMap<String, List<Integer>> map;

        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        SimpleDateFormat month = new SimpleDateFormat("yyyy:MM");

        SimpleDateFormat day = new SimpleDateFormat("yyyy:MM:dd");

        SimpleDateFormat hour = new SimpleDateFormat("yyyy:MM:dd:HH");

        SimpleDateFormat minute = new SimpleDateFormat("yyyy:MM:dd:HH:mm");

        SimpleDateFormat second = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");

        public LogSystem() {
            map = new TreeMap<>();
        }

        public void put(int id, String timestamp) {
            if (map.containsKey(timestamp)) {
                map.get(timestamp).add(id);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(id);
                map.put(timestamp, list);
            }
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            try {
                Date start = second.parse(s);
                Date end = second.parse(e);
                Calendar c = Calendar.getInstance();
                c.setTime(end);
                NavigableMap<String, List<Integer>> sub = null;
                if ("Year".equals(gra)) {
                    c.add(Calendar.YEAR, 1);
                    sub = map.subMap(year.format(start), true, year.format(c.getTime()), false);
                } else if ("Month".equals(gra)) {
                    c.add(Calendar.MONTH, 1);
                    sub = map.subMap(month.format(start), true, month.format(c.getTime()), false);
                } else if ("Day".equals(gra)) {
                    c.add(Calendar.DAY_OF_MONTH, 1);
                    sub = map.subMap(day.format(start), true, day.format(c.getTime()), false);
                } else if ("Hour".equals(gra)) {
                    c.add(Calendar.HOUR, 1);
                    sub = map.subMap(hour.format(start), true, hour.format(c.getTime()), false);
                } else if ("Minute".equals(gra)) {
                    c.add(Calendar.MINUTE, 1);
                    sub = map.subMap(minute.format(start), true, minute.format(c.getTime()), false);
                } else if ("Second".equals(gra)) {
                    c.add(Calendar.SECOND, 1);
                    sub = map.subMap(second.format(start), true, second.format(c.getTime()), false);
                }
                List<Integer> list = new ArrayList<>();
                for (List<Integer> l : sub.values()) {
                    list.addAll(l);
                }
                return list;
            } catch (Exception ex) {
                return new ArrayList<>();
            }
        }
    }

}
