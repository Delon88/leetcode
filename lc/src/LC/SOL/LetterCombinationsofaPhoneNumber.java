package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    class Solution {
        Map<Character, String> map = new HashMap<Character, String>();

        {
            map.put('1', "");
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            map.put('0', " ");
        }

        public List<String> letterCombinations(String digits) {
            List<String> ret = new ArrayList<>();
            if ( digits.length() == 0) return ret;
            dfs( digits, 0 , new char[digits.length()] , ret);
            return ret;
        }

        void dfs(String digits, int start, char[] tmp, List<String> ret) {
            if ( start == digits.length() ) {ret.add(new String(tmp)); return;}

            String letters = map.get(digits.charAt(start));
            for ( int i = 0 ; i < letters.length() ; i++ ) {
                tmp[start] = letters.charAt(i);
                dfs(digits, start + 1, tmp, ret);
            }
        }
    }
}
