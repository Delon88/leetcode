package LC.SOL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {
    class Solution {
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        Pattern p = Pattern.compile(regex);
        public boolean isNumber(String s) {
            s = s.trim();
            return p.matcher(s).matches() ;
        }
    }
}
