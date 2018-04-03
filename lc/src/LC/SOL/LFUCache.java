package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class DoubleLinkedListNode {
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        int key;
        int val;
        int freq = 1;
    }
    private int CAPA ;
    private DoubleLinkedListNode head;
    Map<Integer,DoubleLinkedListNode> map;
    public LFUCache(int capacity) {
        CAPA = capacity;
        DoubleLinkedListNode head = new DoubleLinkedListNode();
        head.next = head;
        head.prev = head;
        head.freq = -1;
        map = new HashMap<>();
    }

    public int get(int key) {
        if ( map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            // update freq and node pos
            if ( node.prev == head ) {
                node.freq++;
                return node.val;
            } else {
                if ( node.prev.val > node.val + 1 ) {
                    node.freq++;
                    return node.val;
                }
            }
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

    }
}
