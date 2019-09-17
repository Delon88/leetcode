package LC.SOL;

import LC.DS.ListNode;

import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Stack<int[]> st = new Stack<>();
            int len = 0; ListNode cur = head;
            while ( cur != null) { cur = cur.next; len++;}
            int[] ret = new int[len];
            cur = head; int i = 0;
            while ( cur != null ) {
                while (!st.isEmpty() && st.peek()[0] < cur.val) {
                    int[] node = st.pop();
                    ret[node[1]] = cur.val;
                }
                st.push(new int[]{cur.val, i});
                cur = cur.next;
                i++;
            }
            return ret;
        }
    }
}
