package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if ( n == 0 ) return new ArrayList<>();
            return generate(1, n);
        }

        List<TreeNode> generate(int start, int end) {
            List<TreeNode> ret = new ArrayList<>();
            if (start > end) {
                ret.add(null);
                return ret;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubs = generate(start, i - 1);
                List<TreeNode> rightSubs = generate(i + 1, end);
                for (TreeNode left : leftSubs) {
                    for (TreeNode right : rightSubs) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ret.add(root);
                    }
                }
            }
            return ret;
        }
    }
}
