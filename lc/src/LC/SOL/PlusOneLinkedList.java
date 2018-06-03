package LC.SOL;

import LC.DS.ListNode;

public class PlusOneLinkedList {
    static class Solution {
        public ListNode plusOne(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode i = dummy;
            ListNode j = dummy;
            // find least significant digits that is not 9
            while ( j.next != null ) {
                j = j.next;
                if ( j.val != 9 ) {
                    i = j;
                }
            }
            // increment this digits
            i.val++;
            i = i.next;
            // set digits after to zero
            while ( i != null ) {
                i.val = 0;
                i = i.next;
            }
            if ( dummy.val != 0  ) return dummy;
            return dummy.next;
        }
    }
}
