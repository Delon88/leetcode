package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeavesofBinaryTree {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);
        r.right = new TreeNode(3);
        s.findLeaves(r);
    }


    static class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            height(root, ret);
            return ret;
        }

        public int height(TreeNode root, List<List<Integer>> ret) {
            if (root == null) {
                return -1;
            }
            int h = 1 + Math.max(height(root.left, ret), height(root.right, ret));
            if ( h == ret.size()) ret.add( new ArrayList<>());
            ret.get(h).add(root.val);
            return h;
        }
    }
}
