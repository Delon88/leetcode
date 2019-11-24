package LC.SOL;

import LC.DS.ListNode;

public class ReverseNodesinkGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k < 2) return head;
            ListNode dummyHead = new ListNode(0);
            ListNode begin = dummyHead;
            dummyHead.next = head;
            int i = 0;
            while (head != null) {
                i++;
                if (i % k == 0) {
                    begin = reverse(begin, head.next);
                    head = begin.next;
                } else {
                    head = head.next;
                }
            }
            return dummyHead.next;
        }

        ListNode reverse(ListNode begin, ListNode end) {
            ListNode cur = begin.next;
            ListNode last = cur;
            ListNode prev = begin;
            while (cur != end) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            begin.next = prev;
            last.next = cur;
            return last;
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
            for (ListNode prev = dummy; l >= k; l -= k) {
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
