package LC.SOL;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    class Solution {
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        public List<String> letterCombinations(String digits) {
            List<String> ret = new ArrayList<>();
            if (digits.length() == 0) return ret;
            dfs(digits, 0, new char[digits.length()], ret);
            return ret;
        }

        void dfs(String digits, int start, char[] tmp, List<String> ret) {
            if (start == digits.length()) {
                ret.add(new String(tmp));
                return;
            }

            String next = letters[digits.charAt(start) - '0'];
            for (int i = 0; i < next.length(); i++) {
                tmp[start] = next.charAt(i);
                dfs(digits, start + 1, tmp, ret);
            }
        }
    }

    class SolutionBFS {
        public List<String> letterCombinations(String digits) {
            LinkedList<String> q = new LinkedList<>();
            if ( q.equals("")) return q;
            q.offer("");
            String[] m = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            for (int i = 0; i < digits.length(); i++) {
                int num = digits.charAt(i) - '0';
                for (int j = q.size(); j > 0; j--) {
                    String tmp = q.poll();
                    for ( char c : m[num].toCharArray()) {
                        q.offer(tmp + c);
                    }
                }
            }
            return q;
        }
    }
}
