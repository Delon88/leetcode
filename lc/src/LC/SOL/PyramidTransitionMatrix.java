package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {
    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, List<Character>> map = new HashMap<>();
            for (String a : allowed) {
                String key = a.substring(0, 2);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(a.charAt(2));
            }
            return build(bottom, map);
        }

        boolean build(String bot, Map<String, List<Character>> map) {
            if (bot.length() == 1) return true;
            for (int i = 0; i < bot.length() - 1; i++) {
                if (!map.containsKey(bot.substring(i, i + 2))) return false;
            }
            List<String> nextBots = new ArrayList<>();
            getNextBots(bot,map,new StringBuilder(),nextBots, 0);
            for ( String nextBot : nextBots) {
                if ( build(nextBot, map)) return true;
            }
            return false;
        }

        void getNextBots(String bot, Map<String, List<Character>> map, StringBuilder b, List<String> nextBots, int idx) {
            if (idx == bot.length() - 1) {
                nextBots.add(b.toString());
                return;
            }

            for ( Character c : map.get(bot.substring(idx , idx + 2)))  {
                b.append(c);
                getNextBots(bot, map, b, nextBots, idx + 1);
                b.deleteCharAt(b.length() - 1);
            }
        }
    }

}
