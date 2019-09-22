package LC.SOL;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    class Solution {
        public String removeDuplicates(String S) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if ( st.isEmpty() || st.peek() != c ) st.push(c);
                else {
                    st.pop();
                }
            }
            StringBuilder b = new StringBuilder();
            while ( !st.isEmpty()) {b.append(st.pop());}
            return b.reverse().toString();
        }
    }
}
