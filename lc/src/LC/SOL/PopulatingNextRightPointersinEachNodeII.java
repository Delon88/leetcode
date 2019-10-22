package LC.SOL;

import LC.DS.Node;

public class PopulatingNextRightPointersinEachNodeII {
    public class Solution {
        public Node connect(Node root) {
            Node levelStart = root;
            Node dummyHead = new Node();
            Node prev = dummyHead;
            while ( levelStart != null ) {
                Node cur = levelStart;
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
                dummyHead.next = null;
            }
            return root;
        }
    }
}
