package LC.SOL;

import LC.DS.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII {
    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int unwegihted = 0, weighted = 0;
            while (!nestedList.isEmpty()) {
                List<NestedInteger> nextLevel = new ArrayList<>();
                for ( NestedInteger ni : nestedList) {
                    if ( ni.isInteger()) {
                        unwegihted += ni.getInteger();
                    } else {
                        nextLevel.addAll(ni.getList());
                    }
                }
                weighted += unwegihted;
                nestedList = nextLevel;
            }
            return weighted;
        }
    }
}
