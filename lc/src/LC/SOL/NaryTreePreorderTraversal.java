package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        List<Integer> ret;
        public List<Integer> preorder(Node root) {
            ret = new ArrayList<>();
            pre(root);
            return ret;
        }

        void pre(Node root) {
            if ( root == null ) return;
            ret.add(root.val);
            for ( Node ch : root.children) {
                pre(ch);
            }
        }
    }
}
