package LC.SOL;

import LC.DS.ListNode;

public class OddEvenLinkedList {
    //    Given a singly linked list, group all odd buckets together followed by the even buckets.
//    Please note here we are talking about the node number and not the value in the nodes.
//
//    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//    Example:
//
//    Input: 1->2->3->4->5->NULL
//    Output: 1->3->5->2->4->NULL
//    Note:
//
//    The relative order inside both the even and odd groups should remain as it was in the input.
//    The first node is considered odd, the second node even and so on ...
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode odd = head, even = head.next, evenHead = head.next;
            while (even != null && even.next != null) {
                ListNode nextOdd = even.next;
                ListNode nextEven = even.next.next;
                odd.next = nextOdd;
                even.next = nextEven;
                odd = nextOdd;
                even = nextEven;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
