package LC.SOL;

import LC.DS.ListNode;

public class RemoveDuplicatesfromSortedList {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if ( head == null ) return null;
            ListNode cur = head;
            while ( cur != null ) {
                ListNode node = cur;
                while ( node != null && cur.val == node.val) {
                    ListNode next = node.next;
                    node.next = null;
                    node = next;
                }
                cur.next = node;
                cur = node;
            }
            return head;
        }
    }
}
