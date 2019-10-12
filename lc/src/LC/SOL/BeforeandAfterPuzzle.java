package LC.SOL;

import java.util.*;

public class BeforeandAfterPuzzle {
    class Solution {
        public List<String> beforeAndAfterPuzzles(String[] phrases) {
            Map<String, List<Integer>> start = new HashMap<>();
            for (int i = 0; i < phrases.length; i++) {
                String[] a = phrases[i].split("\\s");
                start.putIfAbsent(a[0], new ArrayList<>());
                start.get(a[0]).add(i);
            }
            TreeSet<String> ret = new TreeSet<>();
            for (int i = 0; i < phrases.length; i++) {
                String[] a = phrases[i].split("\\s");
                if (start.containsKey(a[a.length - 1])) {
                    for (int index : start.get(a[a.length - 1])) {
                        if (index != i) {
                            String tmp = phrases[i];
                            tmp += (phrases[index].indexOf(" ") == -1 ? "": phrases[index].substring(phrases[index].indexOf(" ")));
                            ret.add(tmp);
                        }
                    }
                }
            }
            List<String> l = new ArrayList<>();
            for ( String s : ret) l.add(s);
            return l;
        }
    }
}
