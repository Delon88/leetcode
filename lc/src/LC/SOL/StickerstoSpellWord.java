package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class StickerstoSpellWord {
    class Solution {

        // dp[s] = 1 + dp[removedString]
        public int minStickers(String[] stickers, String target) {
            int[][] stickerArr = new int[stickers.length][26];
            for (int i = 0; i < stickers.length; i++) {
                for (int j = 0; j < stickers[i].length(); j++) {
                    stickerArr[i][stickers[i].charAt(j) - 'a']++;
                }
            }
            Map<String, Integer> dp = new HashMap<>();
            dp.put("", 0);
            return solve(dp, target, stickerArr);
        }

        private int solve(Map<String, Integer> dp, String target, int[][] stickers) {
            if (dp.containsKey(target)) return dp.get(target);
            int[] tarArr = new int[26];
            for (int i = 0; i < target.length(); i++) tarArr[target.charAt(i) - 'a']++;
            int ret = Integer.MAX_VALUE;
            for (int i = 0; i < stickers.length; i++) {
                int[] sticker = stickers[i];
                if (sticker[target.charAt(0) - 'a'] == 0) continue;
                StringBuilder nextTarget = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    for ( int k = 0 ; k < Math.max(0 , tarArr[j] - sticker[j]); k++) {
                        nextTarget.append((char)(j + 'a'));
                    }
                }
                int tmp = solve(dp, nextTarget.toString(), stickers);
                if ( tmp != - 1) ret= Math.min(ret, tmp + 1);
            }
            dp.put(target, ret == Integer.MAX_VALUE ? -1 : ret);
            return dp.get(target);
        }
    }
}
