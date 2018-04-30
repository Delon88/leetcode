package LC.SOL;

import LC.DS.ListNode;

public class RotateList {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if ( head == null || k == 0 ) return head;
            ListNode cur = head;
            int n = 1;
            while ( cur.next != null  ) {
                cur = cur.next;
                n++;
            }
            cur.next = head;
            cur = head;
            k = k % n ;
            for ( int i = 0 ;  i < n - k - 1 ; i++) {
                cur = cur.next;
            }
            ListNode ret = cur.next;
            cur.next = null;
            return ret;
        }
    }
}
