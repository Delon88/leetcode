package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntersectionofThreeSortedArrays {
    class Solution {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            Map<Integer, Integer> list = new HashMap<>();
            for (int a : arr1) {
                list.put(a, list.getOrDefault(a, 0) + 1);
            }
            for (int a : arr2) {
                list.put(a, list.getOrDefault(a, 0) + 1);
            }
            for (int a : arr3) {
                list.put(a, list.getOrDefault(a, 0) + 1);
            }
            return list.entrySet().stream()
                    .filter(e -> e.getValue() == 3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    class SolutionSpace1 {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> list = new ArrayList();
            int p1 = 0, p2 = 0, p3 = 0;
            while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
                int min = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
                if (arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]) list.add(arr1[p1]);
                if (arr1[p1] == min) p1++;
                if (arr2[p2] == min) p2++;
                if (arr3[p3] == min) p3++;
            }
            return list;
        }
    }
}
