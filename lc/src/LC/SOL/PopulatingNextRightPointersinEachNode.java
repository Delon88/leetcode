package LC.SOL;

import LC.DS.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
    public class Solution {
        public void connect(TreeLinkNode root) {
            TreeLinkNode levelStart = root;
            while ( levelStart != null) {
                TreeLinkNode cur = levelStart;
                while ( cur != null) {
                    if ( cur.left != null ) cur.left.next = cur.right;
                    if ( cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                    cur = cur.next;
                }
                levelStart = levelStart.left;
            }
        }
    }
}
