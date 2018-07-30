package LC.SOL;

import java.util.List;

public class MaximumDepthofNaryTree {

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
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int max = 0;
            for (Node ch : root.children) {
                max = Math.max(maxDepth(ch), max);
            }
            return max + 1;
        }
    }
}
