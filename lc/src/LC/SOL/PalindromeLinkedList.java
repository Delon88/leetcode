package LC.SOL;

import LC.DS.ListNode;

public class PalindromeLinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if ( head == null || head.next == null) return true;
            ListNode fast = head, slow = head;
            while ( fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // reverse slow.next
            ListNode right = slow.next;
            slow.next = null;
            ListNode prev = null;
            ListNode cur = right;
            while ( cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            right = prev;
            ListNode left = head;
            while ( left != null && right != null) {
                if ( left.val != right.val) return false;
                left = left.next;
                right = right.next;
            }
            return true;
        }
    }
}
