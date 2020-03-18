package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DNode {
        public DNode next;
        public DNode prev;
        public int val;
        public int key;

        public DNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    DNode dummyHead;
    Map<Integer, DNode> map;

    int capa;

    public LRUCache(int capacity) {
        dummyHead = new DNode(0, 0);
        dummyHead.next = dummyHead;
        dummyHead.prev = dummyHead;
        map = new HashMap<>();
        this.capa = capacity;
    }

    void remove(DNode node) {
        DNode prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    void addHead(DNode node) {
        DNode next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = next;
        next.prev = node;
    }


    public int get(int key) {
        DNode node = map.get(key);
        if (node != null) {
            int val = node.val;
            remove(node);
            addHead(node);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DNode node = map.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            addHead(node);
        } else {
            DNode newNode = new DNode(key, value);
            map.put(key, newNode);
            addHead(newNode);
            if (map.size() > this.capa) {
                DNode tail = dummyHead.prev;
                remove(tail);
                map.remove(tail.key);
            }
        }
    }
}
