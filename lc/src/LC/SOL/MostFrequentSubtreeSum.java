package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public class Solution {

        int max = 0;
        Map<Integer, Integer> map;

        public int[] findFrequentTreeSum(TreeNode root) {
            max = 0;
            map = new HashMap<>();
            solve(root);
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if ( e.getValue() == max) {
                    list.add(e.getKey());
                }
            }
            int[] ret = new int[list.size()];
            for ( int i = 0 ;i < list.size() ; i++) {
                ret[i] = list.get(i);
            }
            return ret;
        }

        private int solve(TreeNode root) {
            if (root == null) return 0;
            int left = solve(root.left);
            int right = solve(root.right);
            int sum = left + right + root.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.getOrDefault(sum, 0) > max) {
                max = map.getOrDefault(sum, 0);
            }
            return sum;
        }
    }
}
