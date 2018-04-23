package LC.SOL;

import LC.DS.ListNode;

public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode ret = new ListNode(0);
            ListNode cur = ret;
            while (c1 != null && c2 != null) {
                int sum = c1.val + c2.val + carry;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                carry = sum / 10;
                c1 = c1.next;
                c2 = c2.next;
            }
            ListNode remain = c1 == null ? c2 : c1;
            while (remain != null) {
                int sum = remain.val + carry;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                carry = sum / 10;
                remain = remain.next;
            }
            if ( carry != 0 ) cur.next = new ListNode(carry);
            return ret.next;
        }
    }
}
