package LC.SOL;

import LC.DS.ListNode;

public class RemoveLinkedListElements {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if ( head == null ) return head;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            ListNode cur = head;
            while ( cur != null ) {
                if ( cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }
            return dummyHead.next;
        }
    }
}
