package LC.SOL;

import LC.DS.ListNode;

public class RemoveDuplicatesfromSortedList {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur;
                while (cur != null && tmp.val == cur.val) {
                    cur = cur.next;
                }
                tmp.next = cur;
            }
            return head;
        }
    }
}
