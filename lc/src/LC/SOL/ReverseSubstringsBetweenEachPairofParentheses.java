package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    class Solution {
        public String reverseParentheses(String s) {
            Stack<Integer> st = new Stack<>();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') st.push(b.length());
                else if (s.charAt(i) == ')') {
                    int lastlength = st.pop();
                    reverse(b, lastlength, b.length() - 1);
                } else {
                    b.append(s.charAt(i));
                }
            }
            return b.toString();
        }

        void reverse(StringBuilder b, int i, int j) {
            while (i < j) {
                char c = b.charAt(i);
                b.setCharAt(i, b.charAt(j));
                b.setCharAt(j, c);
                i++;
                j--;
            }
        }
    }

    class SoluitonON {
        public String reverseParentheses(String s) {
            int n = s.length();
            Stack<Integer> st = new Stack<>();
            int[] pair = new int[n];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') st.push(i);
                else if (s.charAt(i) == ')') {
                    int j = st.pop();
                    pair[i] = j;
                    pair[j] = i;
                }
            }
            StringBuilder b = new StringBuilder();
            for (int i = 0, d = 1; i < n; i += d) {
                if ( s.charAt(i) == '(' || s.charAt(i) == ')') {
                    i = pair[i];
                    d = -d;
                } else {
                    b.append(s.charAt(i));
                }
            }
            return b.toString();
        }
    }
}
