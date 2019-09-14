package LC.SOL;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions {
    class Solution {
        public boolean isValid(String S) {
            int index = -1;
            while ((index = S.indexOf("abc")) != -1) {
                S = S.substring(0, index) + S.substring(index + 3);
            }
            return S.length() == 0;
        }
    }

    class Solution1 {
        public boolean isValid(String S) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == 'c') {
                    if ( st.isEmpty() || st.pop() != 'b') return false;
                    if ( st.isEmpty() || st.pop() != 'a') return false;
                } else {
                    st.push(S.charAt(i));
                }
            }
            return st.isEmpty();
        }
    }
}
