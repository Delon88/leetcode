package LC.SOL;

import java.util.*;

public class AllOoneDataStructure {
    class AllOne {

        Map<String, DoubleLinkedListNode> map;

        class DoubleLinkedListNode {
            DoubleLinkedListNode prev;
            DoubleLinkedListNode next;
            Set<String> keys;
            int val;

            public DoubleLinkedListNode(int val) {
                this.val = val;
                this.keys = new HashSet<>();
            }
        }

        DoubleLinkedListNode head;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            map = new HashMap<>();
            head = new DoubleLinkedListNode(-1);
            head.next = head;
            head.prev = head;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (!map.containsKey(key)) {
                if (head.prev.val == 1) {
                    head.prev.keys.add(key);
                    map.put(key, head.prev);
                } else {
                    DoubleLinkedListNode newNode = new DoubleLinkedListNode(1);
                    newNode.keys.add(key);
                    insert(head.prev, newNode);
                    map.put(key, newNode);
                }
            } else {
                DoubleLinkedListNode node = map.get(key);
                if (node.prev == head || node.prev.val != node.val + 1) {
                    DoubleLinkedListNode newNode = new DoubleLinkedListNode(node.val + 1);
                    newNode.keys.add(key);
                    // insert newNode
                    insert(node.prev, newNode);
                    map.put(key, newNode);
                } else {
                    node.prev.keys.add(key);
                    map.put(key, node.prev);
                }
                // remove old one
                node.keys.remove(key);
                if (node.keys.isEmpty()) removeNode(node);
            }
        }

        void insert(DoubleLinkedListNode prev, DoubleLinkedListNode node) {
            node.next = prev.next;
            node.prev = prev;
            prev.next.prev = node;
            prev.next = node;
        }

        void removeNode(DoubleLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            DoubleLinkedListNode node = map.get(key);
            if ( node == null) return;
            if (node.val == 1) {
                node.keys.remove(key);
                if (node.keys.isEmpty()) {
                    removeNode(node);
                }
                map.remove(key);
            } else {
                if (node.next.val != node.val - 1) {
                    // create newNode
                    DoubleLinkedListNode newNode = new DoubleLinkedListNode(node.val - 1);
                    newNode.keys.add(key);
                    insert(node, newNode);
                    map.put(key, newNode);
                } else {
                    node.next.keys.add(key);
                    map.put(key, node.next);
                }
                // remove old one
                node.keys.remove(key);
                if (node.keys.isEmpty()) removeNode(node);
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (head.next != head) {
                return head.next.keys.iterator().next();
            } else {
                return "";
            }
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if ( head.prev != head ) {
                return head.prev.keys.iterator().next();
            } else {
                return "";
            }
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
