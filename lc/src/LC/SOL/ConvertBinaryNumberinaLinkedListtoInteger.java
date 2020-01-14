package LC.SOL;

import LC.DS.ListNode;

public class ConvertBinaryNumberinaLinkedListtoInteger {
    class Solution {
        public int getDecimalValue(ListNode head) {
            ListNode cur = head;
            int ret = 0;
            while ( cur != null) {
                ret = ret * 2 + cur.val;
                cur = cur.next;
            }
            return ret;
        }
    }
}
