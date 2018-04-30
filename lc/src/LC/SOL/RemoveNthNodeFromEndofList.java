package LC.SOL;

import LC.DS.ListNode;

public class RemoveNthNodeFromEndofList {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if ( head == null ) return head;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode p1 = dummyHead;
            ListNode p2 = dummyHead;
            while ( n > 0 && p1 != null ) {
                p1 = p1.next;
                n--;
            }
            if ( p1.next == null && n > 0 ) return head;
            while ( p1.next != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            p2.next = p2.next.next;
            return dummyHead.next;
        }
    }

}
