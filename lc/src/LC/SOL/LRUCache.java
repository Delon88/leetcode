package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

public class LRUCache {

     class DoubleLinkedListNode {
        public DoubleLinkedListNode next;
        public DoubleLinkedListNode prev;
        public int val;
        public int key;

        public DoubleLinkedListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    DoubleLinkedListNode dummyHead;
    Map<Integer,DoubleLinkedListNode> map;

    int capa;
    public LRUCache(int capacity) {
        dummyHead = new DoubleLinkedListNode(0, 0);
        dummyHead.next = dummyHead;
        dummyHead.prev = dummyHead;
        map = new HashMap<>();
        this.capa = capacity;
    }

    void remove(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    void addHead(DoubleLinkedListNode node) {
        DoubleLinkedListNode next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = next;
        next.prev = node;
    }


    public int get(int key) {
        DoubleLinkedListNode node = map.get(key);
        if ( node != null ) {
            int val = node.val;
            remove(node);
            addHead(node);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedListNode node = map.get(key);
        if ( node != null) {
            node.val = value;
            remove(node);
            addHead(node);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            map.put(key,newNode);
            addHead(newNode);
            if ( map.size() > this.capa) {
                DoubleLinkedListNode tail = dummyHead.prev;
                remove(tail);
                map.remove(tail.key);
            }
        }
    }
}
