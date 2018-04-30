package LC.SOL;

import LC.DS.ListNode;

public class RemoveDuplicatesfromSortedListII {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            ListNode cur = head;
            while ( cur != null ) {
                ListNode node = cur;
                int count = 0;
                while ( node != null && node.val == cur.val) {
                    node  = node.next;
                    count++;
                }
                if ( count > 1  ) {
                    prev.next = node;
                    cur = node;
                } else {
                    prev = cur;
                    cur = node;
                }
            }
            return dummyHead.next;
        }
    }
}
