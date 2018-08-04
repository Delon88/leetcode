package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        List<Integer> ret;

        public List<Integer> postorder(Node root) {
            ret = new ArrayList<>();
            post(root);
            return ret;
        }

        void post(Node node) {
            if (node == null) return;
            for (Node c : node.children) {
                post(c);
            }
            ret.add(node.val);
        }
    }
}
