package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet<>();
            for ( String e : emails) {
                String[] parts = e.split("@");
                String name = parts[0].replaceAll("\\." , "");
                int pIndex = name.indexOf("+");
                if ( pIndex != -1) name= name.substring(0, pIndex);
                set.add(name + "," + parts[1]);
            }
            return set.size();
        }
    }
}
