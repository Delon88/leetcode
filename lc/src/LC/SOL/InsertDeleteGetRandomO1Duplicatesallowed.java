package LC.SOL;

import java.util.*;

/**
 * Created by nanhong on 12/11/2016.
 */
public class InsertDeleteGetRandomO1Duplicatesallowed {
    public class RandomizedCollection {
        ArrayList<Integer> list;
        HashMap<Integer, Set<Integer>> map;
        java.util.Random rn = new java.util.Random();
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            list = new ArrayList<Integer>();
            map = new HashMap<Integer, Set<Integer>>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = map.containsKey(val);
            if ( ! contain ) map.put( val, new LinkedHashSet<Integer>() );
            map.get(val).add(list.size());
            list.add(val);
            return ! contain ;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean contain = map.containsKey(val);
            if ( ! contain ) return false;
            int loc = map.get(val).iterator().next();
            map.get(val).remove(loc);
            if (loc < list.size() - 1 ) {
                int lastone = list.get( list.size()-1 );
                list.set( loc , lastone );
                map.get(lastone).remove( list.size()-1);
                map.get(lastone).add(loc);
            }
            list.remove(list.size() - 1);

            if (map.get(val).isEmpty()) map.remove(val);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get( rn.nextInt(list.size()) );
        }
    }
}
