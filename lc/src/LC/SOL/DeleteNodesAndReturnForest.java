package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    class Solution {

        List<TreeNode> ret;
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            ret = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for ( int i : to_delete) set.add(i);
            if ( !set.contains(root.val)) ret.add(root);
            solve(root, set);
            return ret;
        }

        TreeNode solve(TreeNode node, Set<Integer> set) {
            if ( node == null ) return null;
            node.left = solve(node.left, set);
            node.right = solve(node.right, set);
            if ( set.contains(node.val)) {
                if ( node.left != null ) ret.add(node.left);
                if ( node.right != null) ret.add(node.right);
                return null;
            }
            return node;
        }
    }
}
