package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    class Solution {
        //        Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary
//        operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
//        Example 1:
//
//        Input: num = "123", target = 6
//        Output: ["1+2+3", "1*2*3"]
//        Example 2:
//
//        Input: num = "232", target = 8
//        Output: ["2*3+2", "2+3*2"]
//        Example 3:
//
//        Input: num = "105", target = 5
//        Output: ["1*0+5","10-5"]
//        Example 4:
//
//        Input: num = "00", target = 0
//        Output: ["0+0", "0-0", "0*0"]
//        Example 5:
//
//        Input: num = "3456237490", target = 9191
//        Output: []
//        2 + 3 * 2 * 2
//        pre=5  ,     (pre - mul) +  ( current * mul )  ,
//        pre= 8      ( pre - mul) + (
        public List<String> addOperators(String num, int target) {
            List<String> ret = new ArrayList<>();
            if (num == null || num.length() == 0) return ret;
            dfs(ret, "", num, target, 0, 0);
            return ret;
        }

        public void dfs(List<String> ret, String path, String num, int target, long pre, long mul) {
            if (num.length() == 0) {
                if (target == pre) {
                    ret.add(path);
                }
                return;
            }
            for (int i = 0; i < num.length(); i++) {
                String nStr = num.substring(0, i + 1);
                if (nStr.charAt(0) == '0' && nStr.length() > 1) return;
                String next = num.substring(i + 1);
                long curNum = Long.parseLong(nStr);
                if (path.length() == 0) {
                    dfs(ret, path + curNum, next, target, curNum, curNum);
                } else {
                    dfs(ret, path + "+" + curNum, next, target, pre + curNum, curNum);
                    dfs(ret,  path + "-" + curNum , next , target, pre - curNum, -curNum);
                    dfs(ret , path + "*" + curNum , next , target, pre - mul + curNum * mul, curNum * mul);
                }
            }
        }
    }
}
