package LC.SOL;

import LC.DS.ListNode;
import LC.DS.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if ( head == null ) return null;
            return build(head , null);
        }

        TreeNode build(ListNode head, ListNode tail) {
            ListNode slow = head, fast = head;
            if ( head == tail) return null;
            while ( fast != tail && fast.next != tail ) {
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = build(head, slow);
            root.right = build(slow.next, tail);
            return root;
        }
    }
}
