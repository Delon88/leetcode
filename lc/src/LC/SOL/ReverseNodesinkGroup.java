package LC.SOL;

import LC.DS.ListNode;

public class ReverseNodesinkGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if ( head == null || k < 2 ) return head;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            int i = 0 ;
            ListNode cur = head;
            ListNode prev = dummyHead;
            while ( cur != null) {
                i++;
                if ( i % k == 0) {
                    ListNode next = cur.next;
                    ListNode newHead = reverse(prev.next, next);
                    ListNode oldHead = prev.next;
                    oldHead.next = next;
                    prev.next = newHead;
                    prev = oldHead;
                    cur = next;
                } else {
                    cur = cur.next;
                }
            }
            return dummyHead.next;
        }

        ListNode reverse(ListNode head, ListNode end) {
            ListNode prev = null;
            ListNode cur = head;
            while ( cur != end) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
