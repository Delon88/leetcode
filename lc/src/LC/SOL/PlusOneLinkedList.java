package LC.SOL;

import LC.DS.ListNode;

/**
 * Created by nanhong on 11/27/2016.
 */
public class PlusOneLinkedList {
    static class Solution {
        public ListNode plusOne(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode i = dummy;
            ListNode j = dummy;
            while ( j.next != null) {
                j = j.next;
                if ( j.val != 9) {
                    i = j;
                }
            }

            i.val++;
            i = i.next;
            while ( i != null) {
                i.val = 0 ;
                i = i.next;
            }
            if ( dummy.val != 0 ) return dummy;
            else return dummy.next;
        }
    }
}
