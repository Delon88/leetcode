package LC.SOL;


import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {
    class ValidWordAbbr {

        Map<String, String> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for ( String w : dictionary) {
                String abbr = encode(w);
                if ( map.containsKey(abbr)) {
                    if ( !map.get(abbr).equals(w)) {map.put(abbr, "");}
                } else {
                    map.put(abbr, w);
                }
            }
        }

        String encode(String w) {
            if (w.length() <= 2) {
                return w;
            } else {
                return "" + w.charAt(0) + (w.length() - 2) + w.charAt(w.length() - 1);
            }
        }


        public boolean isUnique(String word) {
            String abbr = encode(word);
            if ( !map.containsKey(abbr)) {
                return true;
            } else {
                return map.get(abbr).equals(word);
            }
        }
    }

}
