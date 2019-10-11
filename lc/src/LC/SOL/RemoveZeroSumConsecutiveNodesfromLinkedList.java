package LC.SOL;

import LC.DS.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            Map<Integer,ListNode> map = new HashMap<>();
            int prefix = 0;
            ListNode cur = dummy;
            while ( cur != null) {
                prefix += cur.val;
                if ( map.containsKey(prefix)) {
                    ListNode it = map.get(prefix).next;
                    int p = prefix + it.val;
                    while ( p != prefix) {
                        map.remove(p);
                        it = it.next;
                        p += it.val;
                    }
                    map.get(prefix).next = it.next;
                } else {
                    map.put(prefix, cur);
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
