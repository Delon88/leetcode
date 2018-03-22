package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares {
    class Solution {
        // positions[i] = (left, side_length)
        public List<Integer> fallingSquares(int[][] positions) {
            List<Square> list = new ArrayList<>();
            List<Integer> ret = new ArrayList<>();
            int max = 0 ;
            for (int[] p : positions) {
                max = Math.max(max, getHeight(list, new Square(p[0], p[0] + p[1] -1, p[1])));
                ret.add(max);
            }
            return ret;
        }

        public int getHeight(List<Square> list, Square cur) {
            int start = cur.start;
            int end = cur.end;
            int preOverlapedMax = 0;
            for (Square s : list) {
                if (start > s.end) {
                    continue;
                }
                if (end < s.start) {
                    continue;
                }
                preOverlapedMax = Math.max(s.height, preOverlapedMax);
            }
            cur.height += preOverlapedMax;
            list.add(cur);
            return cur.height;
        }

        class Square {
            int start;
            int end;
            int height;

            public Square(int start, int end, int height) {
                this.start = start;
                this.end = end;
                this.height = height;
            }
        }
    }


}
