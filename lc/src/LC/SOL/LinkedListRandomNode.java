package LC.SOL;

import LC.DS.ListNode;

import java.util.Random;

/**
 * Created by nanhong on 12/11/2016.
 */
public class LinkedListRandomNode {
    public class Solution {

        Random rn = new Random();
        ListNode head ;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            if ( head == null ) return -1;
            ListNode cur = head;
            int i = 1 ;
            int ret = cur.val;
            while ( cur.next != null ) {
                cur = cur.next;
                i++;
                if ( rn.nextInt(i) == 0 ) ret = cur.val;
            }
            return ret;
        }
    }
}
