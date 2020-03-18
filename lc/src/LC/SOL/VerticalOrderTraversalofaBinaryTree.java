package LC.SOL;

import LC.DS.TreeNode;

import java.util.*;

public class VerticalOrderTraversalofaBinaryTree {
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // ( x, ( y -> pq of values) )
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            dfs(root, 0, 0, map);
            List<List<Integer>> ret = new ArrayList<>();
            for (TreeMap<Integer, PriorityQueue<Integer>> e : map.values()) {
                List<Integer> l = new ArrayList<>();
                for (PriorityQueue<Integer> q : e.values()) {
                    while (!q.isEmpty()) l.add(q.poll());
                }
                ret.add(l);
            }
            return ret;
        }

        void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
            if (root == null) return;
            if (!map.containsKey(x)) map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue());
            map.get(x).get(y).add(root.val);
            dfs(root.left, x - 1, y + 1, map);
            dfs(root.right, x + 1, y + 1, map);
        }
    }
}
