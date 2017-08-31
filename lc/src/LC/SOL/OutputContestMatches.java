package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class OutputContestMatches {
    class Solution {
        public String findContestMatch(int n) {
            List<String> matches = new ArrayList<>();
            for (int i = 1; i <= n; i++) matches.add(Integer.toString(i));
            while (matches.size() != 1) {
                List<String> newRound = new ArrayList<>();
                for (int i = 0; i < matches.size() / 2; i++) {
                    newRound.add("(" + matches.get(i) + "," + matches.get(matches.size() - i - 1) + ")");
                }
                matches = newRound;
            }
            return matches.get(0);
        }
    }
}
