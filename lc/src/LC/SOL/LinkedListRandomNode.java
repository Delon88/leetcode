package LC.SOL;

import LC.DS.ListNode;

import java.util.Random;

/**
 * Created by nanhong on 12/11/2016.
 */
public class LinkedListRandomNode {
    public class Solution {

        Random rn;
        ListNode head;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            rn = new Random();
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            if ( head == null ) return -1;
            int i = 0;
            ListNode cur = head;
            int ret = cur.val;
            while ( cur != null ) {
                i++;
                if ( rn.nextInt(i) == 0 ) ret = cur.val;
                cur = cur.next;
            }
            return ret;
        }
    }
}
