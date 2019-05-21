package LC.SOL;

import java.util.Arrays;

public class OrderlyQueue {
    class Solution {
        public String orderlyQueue(String S, int K) {
            if (K > 1) {
                char[] arr = S.toCharArray();
                Arrays.sort(arr);
                return new String(arr);
            }
            String ret = S;
            for (int i = 1; i < S.length(); i++) {
                String tmp = S.substring(i) + S.substring(0 , i);
                if ( ret.compareTo(tmp) > 0 ) {
                    ret = tmp;
                }
            }
            return ret;
        }
    }
}
