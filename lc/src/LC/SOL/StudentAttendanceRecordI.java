package LC.SOL;

public class StudentAttendanceRecordI {
    class Solution {
        public boolean checkRecord(String s) {
            int A = 0, L = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    L++;
                } else {
                    L = 0;
                    if (s.charAt(i) == 'A') A++;
                }
                if (L > 2 || A > 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
