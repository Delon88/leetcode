package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    class Solution {
        int i;
        List<Integer> ret;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            i = 0;
            ret = new ArrayList<>();
            return dfs(root, voyage) ? ret: Arrays.asList(-1);
        }

        boolean dfs(TreeNode root, int[] v) {
            if (root == null) return true;
            if (v[i++] != root.val) return false;
            if (root.left != null && root.left.val != v[i]) {
                ret.add(root.val);
                return dfs(root.right, v) && dfs(root.left, v);
            }
            return dfs(root.left, v) && dfs(root.right, v);
        }
    }
}
