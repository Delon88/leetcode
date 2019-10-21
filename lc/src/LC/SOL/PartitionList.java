package LC.SOL;

import LC.DS.ListNode;

public class PartitionList {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lefthead = new ListNode(0), left = lefthead;
            ListNode rightHead = new ListNode(0), right = rightHead;
            ListNode cur = head;
            while ( cur != null) {
                ListNode next = cur.next;
                if ( cur.val < x ) {
                    left.next = cur;
                    left = left.next;
                } else {
                    right.next = cur;
                    right = right.next;
                }
                cur.next = null;
                cur = next;
            }
            left.next = rightHead.next;
            return lefthead.next;
        }
    }
}
