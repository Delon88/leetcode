package LC.SOL;

public class InorderSuccessorinBSTII {
    class Solution {
        public Node inorderSuccessor(Node x) {
            if (x.right == null) {
                Node result = x.parent;
                while (result != null && result.val < x.val) {
                    result = result.parent;
                }
                return result;
            } else {
                Node result = x.right;
                while (result.left != null) {
                    result = result.left;
                }
                return result;
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
