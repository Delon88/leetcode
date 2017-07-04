package LC.SOL;

/**
 * Created by nanhong on 1/15/2017.
 */
public class ValidWordAbbreviation {
    public class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int i = 0, j = 0;
            while (i < abbr.length() && j < word.length()) {
                char c = abbr.charAt(i);
                if ( c == '0') return false;
                if (Character.isDigit(c)) {
                    int num = 0;
                    while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                        num = num * 10 + (abbr.charAt(i) - '0');
                        i++;
                    }
                    j += num;
                } else {
                    if (c == word.charAt(j)) {
                        i++;j++;
                    } else {
                        return false;
                    }
                }
            }
            return j == word.length() && i == abbr.length();
        }
    }
}
