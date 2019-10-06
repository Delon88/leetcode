package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    class Solution {
        // ( 1 << (level - 1), 1 << level - 1 )
        public List<Integer> pathInZigZagTree(int label) {
            int level = 0;
            while ((1 << level) <= label) level++;
            List<Integer> path = new ArrayList<>();
            for (; label >= 1; label /= 2, level--) {
                path.add(label);
                label = ( 1 << level) - 1 - label + ( 1 << ( level  - 1));
            }
            Collections.reverse(path);
            return path;
        }
    }
}
