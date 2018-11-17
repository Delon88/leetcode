package LC.SOL;

import java.util.Stack;

public class BackspaceStringCompare {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> s1 = toStack(S);
            Stack<Character> s2 = toStack(T);
            if ( s1.size() != s2.size() ) return false;
            else {
                while ( !s1.isEmpty()) {
                    if ( s1.pop() != s2.pop()) return false;
                }
                return true;
            }
        }

        Stack<Character> toStack(String s) {
            Stack<Character> stack = new Stack<>();
            for ( int i = 0 ;i < s.length() ; i++) {
                char c = s.charAt(i);
                if ( c == '#')  {
                    if ( !stack.isEmpty()) stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack;
        }
    }
}
