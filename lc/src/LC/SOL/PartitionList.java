package LC.SOL;

import LC.DS.ListNode;

public class PartitionList {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lessHead = new ListNode(0);
            ListNode less = lessHead;
            ListNode rightHead = new ListNode(0);
            ListNode right = rightHead;
            ListNode cur = head;
            while ( cur != null) {
                ListNode next = cur.next;
                if ( cur.val < x ) {
                    less.next = cur;
                    less = less.next;
                } else {
                    right.next = cur;
                    right = right.next;
                }
                cur.next = null;
                cur = next;
            }
            less.next = rightHead.next;
            return lessHead.next;
        }
    }
}
