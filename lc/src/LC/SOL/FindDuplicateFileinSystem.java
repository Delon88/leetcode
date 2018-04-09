package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> map = new HashMap<>();
            for (String path : paths) {
                String[] files = path.split("\\s+");
                for (int i = 1; i < files.length; i++) {
                    String fileName = files[i].substring(0, files[i].indexOf('('));
                    String content = files[i].substring(files[i].indexOf('(') + 1, files[i].indexOf(')'));
                    if ( !map.containsKey(content)) { map.put(content, new ArrayList<>());}
                    map.get(content).add(files[0] + "/" + fileName);
                }
            }
            List<List<String>> ret = new ArrayList<>();
            for ( List<String> dups : map.values()) {
                if (dups.size() >= 2) {
                    ret.add(new ArrayList<>(dups));
                }
            }
            return ret;
        }
    }
}
