package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputisaBST {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            if ( list.size() <= 1 ) return false;
            int start = 0 , end = list.size() - 1;
            while ( start < end) {
                int sum = list.get(start) + list.get(end);
                if ( sum < k ) {
                    start++;
                } else if ( sum > k ) {
                    end--;
                } else {
                    return true;
                }
            }
            return false;
        }

        void inOrder(TreeNode root, List<Integer> inOrder) {
            if ( root == null ) return;
            inOrder(root.left , inOrder);
            inOrder.add(root.val);
            inOrder(root.right , inOrder);
        }
    }
}
