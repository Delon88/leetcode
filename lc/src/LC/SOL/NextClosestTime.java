package LC.SOL;

public class NextClosestTime {
    class Solution {

        int target;

        int minDiff = Integer.MAX_VALUE;

        String ret = "";

        int DayInMinutes = 60 * 24;

        public String nextClosestTime(String time) {
            time = time.replace(":", "");
            target = toMinutes(time);
            char[] digits = time.toCharArray();
            dfs(new StringBuilder(), digits, 0);
            return ret;
        }

        void dfs(StringBuilder tmp, char[] digits, int level) {
            if (level == digits.length) {
                String time = new String(tmp);
                if (isValid(time)) {
                    int curDiff = target < toMinutes(time) ? toMinutes(time) - target : toMinutes(time) + DayInMinutes - target;
                    if (curDiff < minDiff) {
                        minDiff = curDiff;
                        StringBuilder b = new StringBuilder();
                        b.append(tmp).insert(2, ":");
                        ret = b.toString();
                    }
                }
                return;
            }

            for (int i = 0; i < digits.length; i++) {
                tmp.append(digits[i]);
                dfs(tmp, digits, level + 1);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }

        boolean isValid(String time) {
            return Integer.parseInt(time.substring(0, 2)) < 24 && Integer.parseInt(time.substring(2)) < 60;
        }

        int toMinutes(String time) {
            return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(2));
        }
    }
}
