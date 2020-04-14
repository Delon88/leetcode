package LC.SOL;

import LC.DS.TreeNode;

public class SumofNodeswithEvenValuedGrandparent {
    class Solution {
        int sum = 0;
        public int sumEvenGrandparent(TreeNode root) {
            sum = 0;
            traverse(root, null, null);
            return sum;
        }

        void traverse(TreeNode root, TreeNode pa, TreeNode grand) {
            if ( root == null ) return;
            if ( grand != null && grand.val % 2 == 0 ) sum += root.val;
            traverse(root.left, root, pa);
            traverse(root.right, root, pa);
        }
    }
}
