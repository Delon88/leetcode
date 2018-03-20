package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class _24Game {
    class Solution {

        double err = 0.001;

        public boolean judgePoint24(int[] nums) {
            List<Double> list = new ArrayList<>();
            for ( int n : nums) {
                list.add((double)n);
            }
            return dfs(list);
        }

        boolean dfs(List<Double> nums) {
            if (nums.size() == 1) {
                if (Math.abs(nums.get(0) - 24.0) < err) {
                    return true;
                } else {
                    return false;
                }
            }

            for (int i = 0; i < nums.size() - 1; i++) {
                for ( int j = i + 1 ; j < nums.size() ; j++) {
                    List<Double> combs = new ArrayList<>();
                    double o1 = nums.get(i), o2 = nums.get(j);
                    combs.add(o1 + o2);combs.add( o1 - o2);combs.add( o2 - o1);combs.add(o1 * o2);
                    if ( Math.abs(o2) > err ) combs.add( o1 / o2);
                    if ( Math.abs(o1) > err) combs.add(o2/ o1);
                    nums.remove(j); nums.remove(i);
                    for ( Double c : combs) {
                        nums.add(c);
                        if (dfs(nums)) return true;
                        nums.remove(nums.size() - 1);
                    }
                    nums.add(i, o1);
                    nums.add(j, o2);
                }
            }
            return false;
        }

    }
}
