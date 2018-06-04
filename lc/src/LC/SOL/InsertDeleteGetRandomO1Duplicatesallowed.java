package LC.SOL;

import java.util.*;

public class InsertDeleteGetRandomO1Duplicatesallowed {
    public class RandomizedCollection {
        Random rn;
        Map<Integer,List<Integer>> map;
        List<int[]> list;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            rn = new Random();
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean ret = false;
            if ( !map.containsKey(val)) {
                ret = true;
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(list.size());
            list.add(new int[]{val, map.get(val).size() - 1});
            return ret;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if ( !map.containsKey(val)) {
                return false;
            } else {
                List<Integer> valList = map.get(val);
                int valLastIndex = valList.get(valList.size() - 1);
                int[] lastNumber = list.get(list.size() - 1);
                map.get(lastNumber[0]).set(lastNumber[1], valLastIndex);
                list.set(valLastIndex, lastNumber);
                if ( valList.size() == 1 ) {
                    map.remove(val);
                } else {
                    valList.remove(valList.size()-1);
                }

                list.remove(list.size() - 1);
                return true;
            }
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(rn.nextInt(list.size()))[0];
        }
    }
}
