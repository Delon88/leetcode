package LC.SOL;

import LC.DS.ListNode;

public class LinkedListCycleII {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if ( head == null) return head;
            ListNode fast = head;
            ListNode slow = head;
            while ( fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if ( slow == fast) {
                    break;
                }
            }
            if ( fast == null || fast.next == null) return null;
            fast = head;
            while ( slow != fast ) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
