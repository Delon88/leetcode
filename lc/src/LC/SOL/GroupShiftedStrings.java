package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String,List<String>> map = new HashMap<>();
            for ( String s : strings) {
                String encoded = encode(s);
                if ( !map.containsKey(encoded)) {map.put(encoded, new ArrayList<>());}
                map.get(encoded).add(s);
            }
            List<List<String>> ret = new ArrayList<>();
            for ( List<String> v : map.values()) {
                ret.add(v);
            }
            return ret;
        }

        String encode(String s ) {
            if ( s.length() <= 1 ) return "";
            StringBuilder b = new StringBuilder();
            for ( int i = 0 ; i < s.length() - 1 ; i++) {
                int diff = ( s.charAt(i + 1) - s.charAt(i));
                if ( diff < 0 ) diff += 26;
                b.append(diff).append(",");
            }
            return b.toString();
        }
    }
}
