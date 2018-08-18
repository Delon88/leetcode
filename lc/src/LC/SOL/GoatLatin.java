package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    class Solution {
        public String toGoatLatin(String S) {
            String[] arr = S.split("\\s+");
            Set<Character> set = new HashSet<>();
            for ( char c : "aeiouAEIOU".toCharArray()) {
                set.add(c);
            }
            for ( int i = 0 ; i < arr.length ; i++) {
                StringBuilder w = new StringBuilder(arr[i]);
                if ( !set.contains(w.charAt(0))) {
                    char c = w.charAt(0);
                    w.deleteCharAt(0);
                    w.append(c);
                }
                w.append("ma");
                for ( int j = 0 ; j < i + 1 ; j++) {
                    w.append('a');
                }
                arr[i] = w.toString();
            }
            return String.join(" ", arr);
        }
    }
}
