package LC.SOL;

import java.util.Stack;

public class BackspaceStringCompare {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> s1 = toStack(S);
            Stack<Character> s2 = toStack(T);
            if (s1.size() != s2.size()) return false;
            else {
                while (!s1.isEmpty()) {
                    if (s1.pop() != s2.pop()) return false;
                }
                return true;
            }
        }

        Stack<Character> toStack(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '#') {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack;
        }
    }

    class SolutionON {
        public boolean backspaceCompare(String S, String T) {
            for (int i = S.length() - 1, j = T.length() - 1; ; i--, j--) {
                for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); i--) b += S.charAt(i) == '#' ? 1 : -1;
                for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); j--) b += T.charAt(j) == '#' ? 1 : -1;
                if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) return i == -1 && j == -1;
            }
        }
    }


}
