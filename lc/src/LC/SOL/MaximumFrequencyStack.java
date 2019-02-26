package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    class FreqStack {

        Map<Integer,Integer> freq ;
        Map<Integer,Stack<Integer>> freqMap;
        int max;
        public FreqStack() {
            freq = new HashMap<>();
            freqMap = new HashMap<>();
            max = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x , 0) + 1;
            freq.put( x , f);
            max = Math.max(max, f);
            if ( !freqMap.containsKey(f)) freqMap.put(f , new Stack<>());
            freqMap.get(f).push(x);
        }

        public int pop() {
            int x = freqMap.get(max).pop();
            freq.put( x , max - 1);
            if ( freqMap.get(max).isEmpty()) {
                max--;
            }
            return x;
        }
    }
}
