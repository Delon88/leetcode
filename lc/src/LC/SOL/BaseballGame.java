package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    class Solution {
        public int calPoints(String[] ops) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ops.length; i++) {
                int tmp = 0;
                if ("+".equals(ops[i])) {
                    tmp = list.get(list.size() - 1) + list.get(list.size() - 2);
                    list.add(tmp);
                    sum += tmp;
                } else if ("D".equals(ops[i])) {
                    tmp = list.get(list.size() - 1) * 2;
                    list.add(list.get(list.size() - 1) * 2);
                    sum += tmp;
                } else if ("C".equals(ops[i])) {
                    tmp = list.get(list.size() -1);
                    list.remove(list.size() - 1);
                    sum -= tmp;
                } else {
                    tmp = Integer.parseInt(ops[i]);
                    list.add(tmp);
                    sum += tmp;
                }
            }
            return sum;
        }
    }
}
