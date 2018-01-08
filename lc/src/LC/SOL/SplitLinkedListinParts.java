package LC.SOL;

import LC.DS.ListNode;

public class SplitLinkedListinParts {
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] ret = new ListNode[k];
            if (root == null) return ret;
            ListNode cur = root;
            int len = 0;
            while (cur != null) {
                cur = cur.next;
                len++;
            }
            int n = len / k;
            int r = len % k;
            cur = root;
            ListNode prev = null;
            for (int i = 0; cur != null && i < k; i++, r--) {
                ret[i] = cur;
                for ( int j = 0 ; j < n + ( r > 0 ? 1 : 0); j++) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = null;
            }
            return ret;
        }
    }
}
