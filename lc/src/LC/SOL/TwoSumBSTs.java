package LC.SOL;

import LC.DS.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBSTs {
    class Solution {
        Set<Integer> set = new HashSet<>();
        int target = 0;
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            visit(root1);
            this.target = target;
            boolean v = verify(root2);
            return v;
        }
        public void visit(TreeNode root) {
            if(root == null) return;
            set.add(root.val);
            visit(root.left);
            visit(root.right);
        }

        public boolean verify(TreeNode root) {
            if(root == null) {
                return false;
            }
            if(set.contains(target - root.val)) {
                return true;
            }
            return verify(root.left) || verify(root.right);
        }
    }
}
