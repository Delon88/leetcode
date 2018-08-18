package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StickerstoSpellWord {
    class Solution {
        public int minStickers(String[] stickers, String target) {
            int n = target.length() , N =  1 << n ;
            int[] dp = new int[N];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for ( int i = 0 ; i < N ; i++) {
                if ( dp[i] != Integer.MAX_VALUE ) {
                    for ( String sti : stickers ) {
                        int status = i;
                        for ( char c : sti.toCharArray() ) {
                            for ( int j = 0; j < n ; j++) {
                                int pos = 1 << j ;
                                if ( c == target.charAt(j) && ( status & pos ) == 0 ) {
                                    status |= pos;
                                    break;
                                }
                            }
                        }
                        dp[status] = Math.min( dp[i] + 1 , dp[status]);
                    }
                }
            }
            return dp[N -1] == Integer.MAX_VALUE ? -1 : dp[N -1];
        }
    }
}
