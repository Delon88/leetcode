package LC.SOL;

import LC.DS.ListNode;

public class InsertionSortList {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummyHead = new ListNode(0);
            ListNode cur = head;
            while ( cur  != null) {
                ListNode next = cur.next;
                ListNode dCur = dummyHead;
                while ( dCur.next != null && dCur.next.val < cur.val ) {
                    dCur = dCur.next;
                }
                cur.next = dCur.next;
                dCur.next = cur;
                cur = next;
            }
            return dummyHead.next;
        }
    }
}
