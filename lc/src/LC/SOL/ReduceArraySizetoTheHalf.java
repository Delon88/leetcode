package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceArraySizetoTheHalf {
    class Solution {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            List<Integer> values = new ArrayList<>(map.values());
            Collections.sort(values, (a, b) -> b - a);
            int cur = 0;
            int n = arr.length, i = 0;
            while (i < values.size() && cur * 2 < n) {
                cur += values.get(i);
                i++;
            }
            return i;
        }
    }

    class SolutionON {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer>[] list = new ArrayList[arr.length + 1];

            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (int num : map.keySet()) {
                int count = map.get(num);
                if (list[count] == null) {
                    list[count] = new ArrayList<Integer>();
                }
                list[count].add(num);
            }

            int minCount = 0, curSum = 0;
            for ( int i = arr.length ; i >= 0 ; i--) {
                List<Integer> l = list[i];
                if ( l != null ) {
                    for ( int num : l) {
                        curSum += i;
                        minCount++;
                        if ( curSum * 2 >= arr.length) {
                            return minCount;
                        }
                    }
                }
            }
            return arr.length;
        }
    }
}
