package LC.SOL;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    class Solution {
        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
            Map<String, TreeMap<Integer, String>> map = new HashMap<>();
            for (int i = 0; i < username.length; i++) {
                map.putIfAbsent(username[i], new TreeMap<>());
                map.get(username[i]).put(timestamp[i], website[i]);
            }

            TreeMap<String,Set<String>> seq = new TreeMap<>();
            int max = 0;
            for (Map.Entry<String, TreeMap<Integer, String>> e : map.entrySet()) {
                List<String> wl = new ArrayList<>(e.getValue().values());
                if ( wl.size() < 3 ) continue;
                for ( int i = 0 ; i < wl.size() - 2; i++) {
                    for ( int j = i + 1 ; j < wl.size() - 1; j++) {
                        for ( int k = j + 1 ; k < wl.size() ; k++) {
                            String key = wl.get(i) + "," + wl.get(j) + "," + wl.get(k);
                            seq.putIfAbsent(key, new HashSet<>());
                            seq.get(key).add(e.getKey());
                            max = Math.max(seq.get(key).size(), max);
                        }
                    }
                }
            }

            for ( Map.Entry<String,Set<String>> e : seq.entrySet()) {
                if ( e.getValue().size() == max) return Arrays.asList(e.getKey().split(","));
            }
            return new ArrayList<>();
        }
    }
}
