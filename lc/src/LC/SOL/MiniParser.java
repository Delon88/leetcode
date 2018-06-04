package LC.SOL;

import LC.DS.NestedInteger;

import java.util.Stack;

public class MiniParser {
    public class Solution {
        public NestedInteger deserialize(String s) {
            if ( s == null || s.length() == 0) return null;
            if ( s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
            Stack<NestedInteger> stack = new Stack<>();
            NestedInteger ret = null;
            for ( int i  = 0 ;i < s.length() ; i++) {
                char c = s.charAt(i);
                if ( c == '[') {
                    NestedInteger ni = new NestedInteger();
                    if ( !stack.isEmpty() ) {
                        stack.peek().add(ni);
                    }
                    stack.push(ni);
                } else if ( c == ']') {
                    ret = stack.pop();
                } else if ( Character.isDigit(c) || c == '-' ) {
                    int num = 0, sign = c == '-' ? -1 : 1;
                    if ( c == '-' ) i++;
                    while ( i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + ( s.charAt(i) - '0');
                        i++;
                    }
                    i--;
                    stack.peek().add(new NestedInteger(num * sign));
                }
            }
            return ret;
        }
    }
}
