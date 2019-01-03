package LC.SOL;

import LC.DS.TreeNode;
import javafx.util.Pair;

public class SmallestSubtreewithalltheDeepestNodes {
    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return solve(root).getValue();
        }

        Pair<Integer,TreeNode> solve(TreeNode node ) {
            if (node == null) return new Pair<>(0 , null);
            Pair<Integer,TreeNode> left = solve(node.left) , right = solve( node.right);
            int d1 = left.getKey() , d2 = right.getKey();

            if ( d1 == d2 )  {
                return new Pair<>(d1 + 1 , node);
            } else if ( d1 > d2) {
                return new Pair<>(d1 + 1, left.getValue());
            } else {
                return new Pair<>(d2 + 1, right.getValue());
            }
        }
    }
}
