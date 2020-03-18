package LC.SOL;

import java.util.*;

/**
 * Created by nanhong on 12/11/2016.
 */
public class InsertDeleteGetRandomO1 {
    public class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        Random rn = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if ( map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() -1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int tmp = list.get(list.size() -1 );
                int index = map.get(val);
                list.set(index, tmp);
                map.put(tmp, index);
                list.remove(list.size() - 1);
                map.remove(val);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rn.nextInt(list.size()));
        }
    }

    class Solution {
        List<Integer> list;
        Map<Integer,Integer> map;
        Random rn = new Random();
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if ( map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size());
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if ( !map.containsKey(val)) return false;
            int valIndex = map.get(val);
            int lastValue = list.get(list.size() -1);
            map.put(lastValue, valIndex);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rn.nextInt(list.size()));
        }
    }
}
