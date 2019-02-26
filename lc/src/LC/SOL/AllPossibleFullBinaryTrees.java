package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    class Solution {
        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> ret = new ArrayList<>();
            if (N == 1) {
                ret.add(new TreeNode(0));
            }
            N = N - 1;
            for (int i = 1; i < N; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - i);
                for ( TreeNode l : left ) {
                    for ( TreeNode r : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = l ;
                        root.right = r;
                        ret.add(root);
                    }
                }
            }
            return ret;
        }
    }
}
