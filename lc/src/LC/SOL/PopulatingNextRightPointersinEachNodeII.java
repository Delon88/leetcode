package LC.SOL;

import LC.DS.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII {
    public class Solution {
        public void connect(TreeLinkNode root) {
            TreeLinkNode levelStart = root;
            TreeLinkNode dummyHead = new TreeLinkNode(0);
            TreeLinkNode prev = dummyHead;
            while ( levelStart != null ) {
                TreeLinkNode cur = levelStart;
                while ( cur != null ) {
                    if ( cur.left != null ) {
                        prev.next = cur.left;
                        prev = prev.next;
                    }
                    if ( cur.right != null) {
                        prev.next = cur.right;
                        prev = prev.next;
                    }
                    cur = cur.next;
                }
                levelStart = dummyHead.next;
                prev = dummyHead;
                prev.next = null;
            }
        }
    }
}
