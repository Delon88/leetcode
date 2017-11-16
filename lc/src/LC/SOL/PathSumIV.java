package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {
    class Solution {

        Map<Integer, Integer> map;

        int sum = 0;

        public int pathSum(int[] nums) {
            map = new HashMap<>();
            sum = 0;
            if ( nums.length == 0 ) return 0;
            for (int i : nums) {
                int key = i / 10;
                int value = i % 10;
                map.put(key, value);
            }
            tra(nums[0] / 10, 0);
            return sum;
        }

        void tra(int node, int preSum) {
            int level = node / 10;
            int seq = node % 10;
            int leftChild = (level + 1) * 10 + seq * 2 - 1;
            int rightChild = (level + 1) * 10 + seq * 2;
            if (!map.containsKey(leftChild) && !map.containsKey(rightChild)) {
                sum += ( preSum + map.get(node));
                return;
            }

            if ( map.containsKey(leftChild)) tra(leftChild, preSum + map.get(node));
            if ( map.containsKey(rightChild)) tra(rightChild , preSum + map.get(node));
        }
    }
}
