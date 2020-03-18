package LC.SOL;

public class DesignHashMap {
    class MyHashMap {
        final ListNode[] buckets = new ListNode[10000];

        public void put(int key, int value) {
            int i = idx(key);
            if (buckets[i] == null)
                buckets[i] = new ListNode(-1, -1);
            ListNode prev = find(buckets[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            if (buckets[i] == null)
                return -1;
            ListNode node = find(buckets[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (buckets[i] == null) return;
            ListNode prev = find(buckets[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        int idx(int key) {
            return Integer.hashCode(key) % buckets.length;
        }

        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
