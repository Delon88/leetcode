package LC.SOL;

import LC.DS.ListNode;

public class SortList {
    class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        public ListNode mergeSort( ListNode head) {
            if ( head == null || head.next == null) return head;
            ListNode l1 = head;
            ListNode l2 = head;
            while ( l2.next != null && l2.next.next != null) {
                l1 = l1.next;
                l2 = l2.next.next;
            }

            ListNode right = l1.next;
            ListNode left = head;
            l1.next = null;
            left = mergeSort(left);
            right = mergeSort(right);
            return merge( left , right);

        }

        public ListNode merge(ListNode l1 , ListNode l2 ) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = l1;
            ListNode prev = dummyHead;
            while ( l1 != null && l2 != null) {
                if ( l1.val > l2.val) {
                    ListNode next = l2.next;
                    prev.next = l2;
                    l2.next = l1;
                    l2 = next;
                } else {
                    l1 = l1.next;
                }
                prev = prev.next;
            }
            if ( l2 != null ) {
                prev.next = l2;
            }
            return dummyHead.next;
        }
    }
}
