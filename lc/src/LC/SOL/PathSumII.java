package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ret = new ArrayList<>();
            dfs(root, new ArrayList<>(), sum , ret);
            return ret;
        }

        void dfs(TreeNode root, List<Integer> tmp, int sum, List<List<Integer>> ret) {
            if (root == null) return;
            tmp.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {
                ret.add(new ArrayList<>(tmp));
            }

            dfs(root.left, tmp, sum - root.val, ret);
            dfs(root.right, tmp, sum - root.val, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
