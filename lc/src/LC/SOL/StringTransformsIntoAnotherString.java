package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTransformsIntoAnotherString {
    class Solution {
        public boolean canConvert(String str1, String str2) {
            if ( str1.equals(str2)) return true;
            if ( str1.length() != str2.length() ) return false;
            Map<Character,Character> map = new HashMap<>();
            for ( int i = 0 ; i < str1.length() ; i++) {
                if ( map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i)) return false;
                map.put(str1.charAt(i), str2.charAt(i));
            }
            return new HashSet<>(map.values()).size() < 26;
        }
    }
}
