package LC.SOL;

import LC.DS.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {
    class Solution {
        Map<String, Integer> map;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            map = new HashMap<>();
            List<TreeNode> ret = new ArrayList<>();
            if (root == null) return ret;
            postTra(root, ret);
            return ret;
        }

        String postTra(TreeNode root, List<TreeNode> ret) {
            if (root == null) return "#";
            String leftSub = postTra(root.left, ret);
            String rightSub = postTra(root.right, ret);
            String tree = root.val + "," + leftSub + "," + rightSub;
            if (map.containsKey(tree) && map.get(tree) == 1) {
                ret.add(root);
            }
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            return tree;
        }
    }
}
