package LC.SOL;

import LC.DS.ListNode;

public class ReverseLinkedListII {
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if ( head == null ) return head;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode reversePrev = dummyHead;
            for ( int i = 0 ;i < m - 1 ;i++) {
                reversePrev = reversePrev.next;
            }

            ListNode reverseHead = reversePrev.next;
            ListNode cur = reverseHead;
            ListNode prev = null;
            for ( int i = 0 ; i <= n- m ; i++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            reversePrev.next = prev;
            reverseHead.next = cur;
            return dummyHead.next;
        }
    }
}
