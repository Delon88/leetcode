package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionforaGivenEquation {
    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> ret = new ArrayList<>();
            int x = 1, y = 1000;
            while ( x <= 1000 && y > 0 ) {
                int v = customfunction.f(x , y);
                if ( v > z) y--;
                else if ( v < z) x++;
                else ret.add(Arrays.asList(x++ , y--));
            }
            return ret;
        }
    }

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    }
}
