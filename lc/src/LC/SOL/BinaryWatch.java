package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public class Solution {
        /**
         * constraints : hour [0 , 11] ,  minutes: [ 0 , 59]
         *
         * @param num
         * @return
         */
        public List<String> readBinaryWatch(int num) {
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if (Integer.bitCount(i * 60 + j) == num) {
                        ret.add(String.format("%d:%02d", i, j));
                    }
                }
            }
            return ret;
        }
    }
}
