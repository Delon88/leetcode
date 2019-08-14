package LC.SOL;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Comparator<String> c = new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    String l1 = s1.split("\\s", 2)[1];
                    String l2 = s2.split("\\s", 2)[1];
                    if ( Character.isDigit(l1.charAt(0)) && Character.isDigit(l2.charAt(0))) {
                        return 0;
                    } else if ( Character.isDigit(l1.charAt(0)) && !Character.isDigit(l2.charAt(0))) {
                        return 1;
                    } else if ( !Character.isDigit(l1.charAt(0)) && Character.isDigit(l2.charAt(0))) {
                        return -1;
                    } else {
                        int r =  l1.compareTo(l2);
                        if ( r == 0 ) return s1.split("\\s")[0].compareTo(s2.split("\\s")[0]);
                        else return r;
                    }
                }
            };
            Arrays.sort(logs, c);
            return logs;
        }
    }
}
