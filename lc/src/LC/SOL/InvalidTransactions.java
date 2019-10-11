package LC.SOL;

import java.util.*;

public class InvalidTransactions {
    class Solution {
        public List<String> invalidTransactions(String[] transactions) {
            Map<String, List<Node>> map = new HashMap<>();
            for (int i = 0; i < transactions.length; i++) {
                String[] t = transactions[i].split(",");
                map.putIfAbsent(t[0], new ArrayList<>());
                map.get(t[0]).add(new Node(t[1], t[2], t[3], i));
            }
            boolean[] inval = new boolean[transactions.length];
            for (List<Node> l : map.values()) {
                Collections.sort(l, (n1, n2) -> n1.time - n2.time);
                for (int i = 0; i < l.size(); i++) {
                    for (int j = i + 1; j < l.size() && l.get(i).time + 60 >= l.get(j).time; j++) {
                        if (!l.get(i).city.equals(l.get(j).city)) {
                            inval[l.get(i).index] = true;
                            inval[l.get(j).index] = true;
                        }
                    }
                    if (l.get(i).amount > 1000) inval[l.get(i).index] = true;
                }
            }
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < inval.length; i++) {
                if (inval[i]) ret.add(transactions[i]);
            }
            return ret;
        }

        class Node {
            int time;
            int amount;
            String city;
            int index;

            Node(String time, String amount, String city, int index) {
                this.time = Integer.parseInt(time);
                this.amount = Integer.parseInt(amount);
                this.city = city;
                this.index = index;
            }
        }
    }
}
