package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> ret = new ArrayList<>();
            dfs(word, "", 0, 0, ret);
            return ret;
        }

        void dfs(String word, String tmp, int start, int count, List<String> ret) {
            if (start == word.length()) {
                if (count > 0) tmp += count;
                ret.add(tmp);
                return;
            }
            // encode
            dfs(word, tmp, start + 1, count + 1, ret);
            // not encode
            dfs(word, tmp + (count == 0 ? "" : count) + word.charAt(start), start + 1, 0, ret);
        }
    }
}
