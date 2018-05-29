package LC.SOL;

import LC.DS.TreeNode;

public class HouseRobberIII {
    class Solution {
        public int rob(TreeNode root) {
            int[] ret = solve(root);
            return Math.max(ret[0] , ret[1]);
        }

        // return prevRob, prevNotRob
        int[] solve(TreeNode root) {
            if ( root == null ) return new int[]{0 , 0};
            int[] left = solve(root.left);
            int[] right = solve(root.right);
            // current rob case
            int[] ret = {0 , 0};
            ret[0] = left[1] + right[1] + root.val;
            ret[1] = Math.max(Math.max(left[1] + right[1], left[1] + right[0]) , Math.max(left[0] + right[1] , left[0] + right[0]));
            return ret;
        }
    }
}
