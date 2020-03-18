package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ret = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                boolean f3 = (i % 3 == 0) ? true : false;
                boolean f5 = (i % 5 == 0) ? true : false;
                StringBuilder b = new StringBuilder();
                if (f3) b.append("Fizz");
                if (f5) b.append("Buzz");
                if (!f3 && !f5) b.append(i);
                ret.add(b.toString());
            }
            return ret;
        }
    }
}
