package LC.SOL;

import LC.DS.NestedInteger;

import java.util.List;

public class NestedListWeightSum {
    class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            return solve(nestedList, 1);
        }

        public int solve(List<NestedInteger> list, int depth) {
            int sum = 0;
            for ( NestedInteger i : list) {
                if ( i.isInteger()) {
                    sum += i.getInteger() * depth;
                } else {
                    sum += solve(i.getList(), depth + 1);
                }
            }
            return sum;
        }
    }
}
