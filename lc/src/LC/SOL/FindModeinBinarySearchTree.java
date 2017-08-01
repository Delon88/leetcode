package LC.SOL;

import LC.DS.TreeNode;

public class FindModeinBinarySearchTree {
    public class Solution {

        int curValue = 0;
        int curCount = 0;
        int maxCount = 0;
        int modeCount = 0;
        int[] modes;

        public int[] findMode(TreeNode root) {
            inOrder(root);
            modes = new int[modeCount];
            modeCount = 0;
            curCount = 0;
            inOrder(root);
            return modes;
        }

        public void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            // handle curValue
            if (curValue != root.val) {
                curCount = 0;
                curValue = root.val;
            }
            curCount++;
            if (curCount > maxCount) {
                maxCount = curCount;
                modeCount = 1;
            } else if (curCount == maxCount) {
                if (modes != null) {
                    modes[modeCount] = curValue;
                }
                modeCount++;
            }

            inOrder(root.right);
        }
    }
}
