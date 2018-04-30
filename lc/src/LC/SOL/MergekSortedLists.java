package LC.SOL;

import LC.DS.ListNode;

import java.util.PriorityQueue;

public class MergekSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q = new PriorityQueue<>( (l1, l2) -> l1.val - l2.val);
            for ( ListNode l : lists) {
                if ( l != null) q.offer(l);
            }
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while ( !q.isEmpty()) {
                ListNode node = q.poll();
                cur.next = node;
                cur = cur.next;
                if ( node.next != null ) {
                    q.offer(node.next);
                }
            }
            return dummyHead.next;
        }
    }
}
