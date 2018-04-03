package LC.SOL;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
//
//    Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
//
//    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//    put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
//    it should invalidate the least frequently used item before inserting a new item.
//    For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
//    the least recently used key would be evicted.
//
//    Follow up:
//    Could you do both operations in O(1) time complexity?
//
//    Example:
//
//    LFUCache cache = new LFUCache( 2 /* capacity */ );

//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.get(3);       // returns 3.
//cache.put(4, 4);    // evicts key 1.
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4

    // key value
    Map<Integer, Integer> cache;
    // key freq
    Map<Integer, Integer> freqMap;
    // freq -> key set
    Map<Integer, LinkedHashSet<Integer>> freqToKey;

    private int CAPA;

    int minFreq = -1;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        freqToKey = new HashMap<>();
        CAPA = capacity;
    }

    public int get(int key) {
        if ( cache.containsKey(key)) {
            int value = cache.get(key);
            int fr = freqMap.get(key);
            freqToKey.get(fr).remove(key);
            if (freqToKey.get(fr).size() == 0) {
                freqToKey.remove(fr);
                if ( fr == minFreq) {
                    minFreq++;
                }
            }

            fr++;
            freqMap.put(key, fr);
            if ( !freqToKey.containsKey(fr)) {
                freqToKey.put(fr, new LinkedHashSet<>());
            }
            freqToKey.get(fr).add(key);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if ( CAPA <= 0) return;
        if ( cache.containsKey(key)) {
            get(key);
            cache.put(key, value);
        } else {
            if (cache.size() >= CAPA) {
                // evict oldest
                int evict = freqToKey.get(minFreq).iterator().next();
                freqToKey.get(minFreq).remove(evict);
                if (freqToKey.get(minFreq).size() == 0) freqToKey.remove(minFreq);
                cache.remove(evict);
                freqMap.remove(evict);
            }
            if (!freqToKey.containsKey(1)) {
                freqToKey.put(1, new LinkedHashSet<>());
            }
            minFreq = 1;
            freqToKey.get(1).add(key);
            cache.put(key, value);
            freqMap.put(key, 1);
        }
    }
}
