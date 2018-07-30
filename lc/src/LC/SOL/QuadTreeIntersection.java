package LC.SOL;

public class QuadTreeIntersection {


    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    class Solution {
        public Node intersect(Node quadTree1, Node quadTree2) {
            Node q1 = quadTree1, q2 = quadTree2;
            if (q1.isLeaf) {
                return q1.val ? q1 : q2;
            } else if (q2.isLeaf) {
                return q2.val ? q2 : q1;
            } else {
                Node root = new Node();
                Node topLeft = intersect(q1.topLeft, q2.topLeft);
                Node topRight = intersect(q1.topRight, q2.topRight);
                Node bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
                Node bottomRight = intersect(q1.bottomRight, q2.bottomRight);
                boolean val = topLeft.val;
                if (val == topLeft.val && val == topRight.val && val == bottomLeft.val && val == bottomRight.val && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                    root.isLeaf = true;
                    root.val = val;
                } else {
                    root.topLeft = topLeft;
                    root.topRight = topRight;
                    root.bottomLeft = bottomLeft;
                    root.bottomRight = bottomRight;
                }
                return root;
            }

        }
    }
}
