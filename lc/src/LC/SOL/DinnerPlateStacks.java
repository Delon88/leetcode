package LC.SOL;

import java.util.*;

public class DinnerPlateStacks {
    class DinnerPlates {


        TreeMap<Integer, Stack<Integer>> m;
        TreeSet<Integer> av;
        int cap;

        public DinnerPlates(int capacity) {
            m = new TreeMap<>();
            av = new TreeSet<>();
            cap = capacity;
        }

        public void push(int val) {
            if (av.isEmpty()) {
                av.add(m.size() == 0 ? 0: m.lastKey() + 1);
            }
            Stack<Integer> st = m.getOrDefault(av.first(), new Stack<>());
            st.push(val);
            m.put(av.first(), st);
            if ( st.size() == cap) av.remove(av.first());
        }

        public int pop() {
            if ( m.isEmpty()) return -1;
            return popAtStack(m.lastKey());
        }

        public int popAtStack(int index) {
            if ( !m.containsKey(index) || m.get(index).size() == 0) return -1;
            Stack<Integer> st = m.get(index);
            int ret = st.pop();
            if ( st.isEmpty()) m.remove(index);
            av.add(index);
            return ret;
        }
    }
}
