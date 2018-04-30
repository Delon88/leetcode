package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            if ( n <= 0) return ret;
            char[] tmp = new char[2 * n];
            generate(tmp, 0 , 0 , ret , n);
            return ret;
        }

        void generate(char[] tmp, int left, int right, List<String> ret, int n) {
            if ( left + right == 2 * n) ret.add(new String(tmp));
            if ( left < n ) {
                tmp[left + right] = '(';
                generate(tmp, left + 1 , right , ret , n );
            }
            if ( left > right ) {
                tmp[left + right] = ')';
                generate(tmp , left, right + 1, ret, n );
            }
        }
    }
}
