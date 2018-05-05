package LC.SOL;

import LC.DS.RandomListNode;

public class CopyListwithRandomPointer {
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return head;
            RandomListNode cur = head;
            // copy and link
            while ( cur != null) {
                RandomListNode next = cur.next;
                cur.next = new RandomListNode(cur.label);
                cur.next.next = next;
                cur = next;
            }

            // copy random
            cur = head;
            while ( cur != null) {
                if ( cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            // recover list
            RandomListNode ret = head.next;
            cur = head;
            while ( cur != null) {
                RandomListNode dupCur = cur.next;
                RandomListNode next = dupCur.next;
                if ( next != null) {
                    dupCur.next = next.next;
                }
                cur.next = next;
                cur = next;
            }
            return ret;
        }
    }
}
