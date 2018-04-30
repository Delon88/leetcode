package LC.SOL;

import LC.DS.ListNode;

public class SwapNodesinPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode cur = head;
            ListNode prev = dummyHead;
            while ( cur != null && cur.next != null) {
                ListNode next = cur.next.next;
                prev.next = cur.next;
                cur.next.next = cur;
                cur.next = next;
                prev = cur;
                cur = next;
            }
            return dummyHead.next;
        }
    }
}
