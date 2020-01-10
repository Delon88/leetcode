package LC.SOL;

import LC.DS.RandomListNode;

public class CopyListwithRandomPointer {
    public class Solution {
        public Node copyRandomList(Node head) {
            // make copy
            if (head == null) return head;
            Node cur = head;
            while (cur != null) {
                Node next = cur.next;
                cur.next = new Node(cur.val, null, null);
                cur.next.next = next;
                cur = next;
            }
            // copy random
            cur = head;
            while ( cur != null) {
                if ( cur.random != null ) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            // recover
            cur = head; Node ret = cur.next;
            while ( cur != null ) {
                Node dupCur = cur.next;
                Node next = dupCur.next;
                if ( next != null) {
                    dupCur.next = next.next;
                }
                cur.next = next;
                cur = next;
            }
            return ret;
        }
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
