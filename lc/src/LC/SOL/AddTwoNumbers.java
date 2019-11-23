package LC.SOL;

import LC.DS.ListNode;

public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0;
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode dummy = new ListNode(0);
            ListNode cd = dummy;
            while ( c1 != null || c2 != null) {
                if ( c1 != null) { sum+= c1.val; c1 = c1.next;}
                if ( c2 != null) { sum += c2.val; c2 = c2.next;}
                cd.next = new ListNode( sum % 10);
                cd = cd.next;
                sum /= 10;
            }
            if ( sum != 0) cd.next = new ListNode(sum);
            return dummy.next;
        }
    }
}
