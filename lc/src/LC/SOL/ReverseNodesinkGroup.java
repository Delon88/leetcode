package LC.SOL;

import LC.DS.ListNode;

public class ReverseNodesinkGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k < 2) return head;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            int i = 0;
            ListNode cur = head;
            ListNode prev = dummyHead;
            while (cur != null) {
                i++;
                if (i % k == 0) {
                    ListNode next = cur.next;
                    ListNode newHead = reverse(prev.next, next);
                    ListNode oldHead = prev.next;
                    oldHead.next = next;
                    prev.next = newHead;
                    prev = oldHead;
                    cur = next;
                } else {
                    cur = cur.next;
                }
            }
            return dummyHead.next;
        }

        ListNode reverse(ListNode head, ListNode end) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != end) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }

    class Solution1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            int l = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                l++;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            cur = head;
            for (ListNode prev = dummy ; l >= k; l -= k) {
                for (int i = 1; i < k; i++) {
                    ListNode next = cur.next.next;
                    cur.next.next = prev.next;
                    prev.next = cur.next;
                    cur.next = next;
                }
                prev = cur;
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
