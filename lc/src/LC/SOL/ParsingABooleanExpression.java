package LC.SOL;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParsingABooleanExpression {
    class Solution {
        public boolean parseBoolExpr(String expression) {
            Stack<Character> st = new Stack<>();
            for ( int i = 0 ; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if ( c == ')') {
                    Set<Character> seen = new HashSet<>();
                    while ( st.peek() != '(' ) seen.add(st.pop());
                    st.pop();
                    if ( st.peek() == '|') st.push(seen.contains('t') ? 't' : 'f');
                    else if ( st.peek() == '&') st.push(seen.contains('f') ? 'f' : 't');
                    else if ( st.peek() == '!') st.push(seen.contains('t') ? 'f' : 't');
                } else if ( c != ',') {
                    st.push(c);
                }
            }
            return st.peek() == 't';
        }
    }
}