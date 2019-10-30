package LC.SOL;

import LC.DS.Node;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    class Solution {
        Node prev = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            Node dummy = new Node();
            prev = dummy;
            inorder(root);
            //connect head and tail
            prev.right = dummy.right;
            dummy.right.left = prev;
            return dummy.right;
        }

        private void inorder(Node cur) {
            if (cur == null) return;
            inorder(cur.left);
            prev.right = cur;
            cur.left = prev;
            prev = cur;
            inorder(cur.right);
        }
    }
}
