package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            if (list1.length == 0 || list2.length == 0) return new String[0];
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            int minSum = list1.length + list2.length - 2;
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    int tmpIndexSum = i + map.get(list2[i]);
                    if (tmpIndexSum < minSum) {
                        ret.clear();
                        ret.add(list2[i]);
                        minSum = i + map.get(list2[i]);
                    } else if (tmpIndexSum == minSum) {
                        ret.add(list2[i]);
                    }
                }
            }
            String[] arr = new String[ret.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ret.get(i);
            }
            return arr;
        }
    }
}
