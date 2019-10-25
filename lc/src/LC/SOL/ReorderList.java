package LC.SOL;

import LC.DS.ListNode;

public class ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            if ( head == null) return;
            ListNode slow = head, fast = head;
            while ( fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode left = head;
            ListNode right = slow.next;
            slow.next = null;
            // reverse right half
            ListNode prev = null;
            ListNode cur = right;
            while ( cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            right = prev;

            ListNode curLeft = left;
            ListNode curRight = right;
            while ( curLeft != null && curRight != null) {
                ListNode nextLeft = curLeft.next;
                ListNode nextRight = curRight.next;
                curLeft.next = curRight;
                curRight.next = nextLeft;
                curLeft = nextLeft;
                curRight = nextRight;
            }
        }
    }
}
