package LC.SOL;

public class StudentAttendanceRecordII {
    class Solution {
        int count = 0;

        char[] s = "ALP".toCharArray();

        public int checkRecord(int n) {
            dfs(0, new StringBuilder(), n, 0, 0);
            return count;
        }

        void dfs(int level, StringBuilder at, int n, int A, int L) {
            if (A > 1 || L > 2) return;

            if (at.length() == n) {
                count++;
                return;
            }

            for (char c : s) {
                at.append(c);
                if (c == 'L') {
                    L++;
                } else {
                    L = 0;
                    if (c == 'A') A++;
                }
                dfs(level + 1, at, n, A, L);
                at.deleteCharAt(at.length() - 1);
            }
        }

    }
}
