package LC.SOL;

import LC.DS.TreeNode;

public class SumRoottoLeafNumbers {
    class Solution {

        int sum;
        public int sumNumbers(TreeNode root) {
            sum = 0;
            solve(root, new StringBuilder());
            return sum;
        }

        void solve(TreeNode root, StringBuilder b ) {
            if ( root == null  ) return ;
            b.append(root.val);
            if ( root.left == null && root.right == null) {
                sum += Integer.parseInt(b.toString());
            }
            solve(root.left, b);
            solve(root.right, b);
            b.deleteCharAt(b.length() - 1);
        }


    }
}
