package LC.SOL;

import java.util.Stack;

public class ValidateStackSequences {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> st = new Stack<>();
            int i = 0;
            for (int p : pushed) {
                st.push(p);
                if ( st.peek() == popped[i]) {
                    while ( !st.isEmpty() && st.peek() == popped[i]) {
                        st.pop();
                        i++;
                    }
                }
            }
            return st.isEmpty();
        }
    }
}
