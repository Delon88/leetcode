package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OnlineElection {
    class TopVotedCandidate {

        TreeMap<Integer, Integer> map;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            map = new TreeMap<>();
            Map<Integer, Integer> count = new HashMap<>();
            this.times = times;
            int lead = -1, n = persons.length;
            for (int i = 0; i < n; i++) {
                count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
                if (i == 0) {
                    lead = persons[0];
                } else if (count.get(persons[i]) >= count.get(lead)) {
                    lead = persons[i];
                }
                map.put(times[i], lead);
            }
        }

        public int q(int t) {
            int time = map.floorKey(t);
            return map.get(time);
        }
    }

}
