package LC.SOL;

/**
 * Created by nanhong on 1/15/2017.
 */
public class ValidWordAbbreviation {
    public class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int i = 0 , j = 0 ;
            while ( i < word.length() && j < abbr.length()) {
                char w = word.charAt(i), a = abbr.charAt(j);
                if ( w == a ) {
                    i++;j++;continue;
                }
                if ( a == '0' || !Character.isDigit(a)) {
                    return false;
                } else {
                    int num = 0;
                    while ( j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                        num = num * 10 + (abbr.charAt(j) - '0');
                        j++;
                    }
                    i += num;
                }
            }
            return i == word.length() && j == abbr.length();
        }
    }
}
