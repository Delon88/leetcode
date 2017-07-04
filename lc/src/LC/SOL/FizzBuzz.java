package LC.SOL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanhong on 1/15/2017.
 */
public class FizzBuzz {
    public class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ret = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                boolean div3 = (i % 3) == 0;
                boolean div5 = (i % 5) == 0;
                if (!div3 && !div5) ret.add(Integer.toString(i));
                else if (div3 && div5) ret.add("FizzBuzz");
                else if (div3) ret.add("Fizz");
                else if (div5) ret.add("Buzz");
            }
            return ret;
        }
    }
}
