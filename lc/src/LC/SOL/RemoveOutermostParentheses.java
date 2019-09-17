package LC.SOL;


public class RemoveOutermostParentheses {
    class Solution {
        public String removeOuterParentheses(String S) {
            int left = 0;
            String ret = "";
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '(') {
                    left++;
                    b.append('(');
                } else {
                    left--;
                    b.append(')');
                }
                if (left == 0) {
                    ret += b.toString().substring(1, b.length() - 1);
                    b = new StringBuilder();
                }
            }
            return ret;
        }
    }

    class Solution1 {
        public String removeOuterParentheses(String S) {
            int open = 0;
            StringBuilder b = new StringBuilder();
            for ( char c : S.toCharArray()) {
                if ( c == '(' && open++ > 0 ) b.append('(');
                if ( c == ')' && open-- > 1) b.append(')');
            }
            return b.toString();
        }
    }
}
