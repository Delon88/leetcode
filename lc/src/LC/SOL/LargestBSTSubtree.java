package LC.SOL;

import LC.DS.TreeNode;

public class LargestBSTSubtree {


    class Solution {
        class Node {
            int min, max, size;

            public Node(int min, int max, int size) {
                this.min = min;
                this.max = max;
                this.size = size;
            }
        }

        int max;
        public int largestBSTSubtree(TreeNode root) {
            max = 0;
            solve(root);
            return max;
        }

        Node solve(TreeNode root) {
            if ( root == null ) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            Node left = solve(root.left);
            Node right = solve( root.right);
            if ( left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min ) {
                return new Node( 0 , 0 , -1);
            }
            int size = left.size + right.size + 1;
            max = Math.max(size , max);
            return new Node( Math.min(root.val, left.min), Math.max(root.val, right.max), size);
        }
    }
}
