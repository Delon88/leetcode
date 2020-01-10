package LC.SOL;

import LC.DS.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII {
    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int numbers = 0, total = 0;
            while (!nestedList.isEmpty()) {
                List<NestedInteger> nextLevel = new ArrayList<>();
                for ( NestedInteger ni : nestedList) {
                    if ( ni.isInteger()) {
                        numbers += ni.getInteger();
                    } else {
                        nextLevel.addAll(ni.getList());
                    }
                }
                total += numbers;
                nestedList = nextLevel;
            }
            return total;
        }
    }
}
