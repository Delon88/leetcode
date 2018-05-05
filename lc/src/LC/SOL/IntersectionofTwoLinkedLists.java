package LC.SOL;

import LC.DS.ListNode;

public class IntersectionofTwoLinkedLists {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            int lenA = getLen(headA), lenB = getLen(headB);
            ListNode longer = lenA > lenB ? headA : headB;
            ListNode shorter = lenA <= lenB ? headA: headB;
            for ( int i = 0 ; i < Math.abs(lenA - lenB) ; i++) {
                longer = longer.next;
            }
            while ( longer != shorter) {
                longer = longer.next;
                shorter = shorter.next;
            }
            return longer;
        }

        int getLen(ListNode head) {
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                count++;
            }
            return count;
        }
    }
}
