package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String,Integer> map = new HashMap<>();
            for ( String cp : cpdomains) {
                String[] arr = cp.split(" ");
                int count = Integer.parseInt(arr[0]);
                String[] domains = arr[1].split("\\.");
                String d = "";
                for ( int i = domains.length - 1 ; i >= 0; i--) {
                    if ( i == domains.length - 1 ) {
                        d = domains[i] + d;
                    } else {
                        d = domains[i] + "." + d;
                    }
                    map.put(d, map.getOrDefault(d, 0) + count );
                }
            }
            List<String> ret = new ArrayList<>();
            for ( Map.Entry<String,Integer> e : map.entrySet()) {
                ret.add(e.getValue() + " "  + e.getKey());
            }
            return ret;
        }
    }
}
