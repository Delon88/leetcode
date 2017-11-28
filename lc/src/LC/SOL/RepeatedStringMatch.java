package LC.SOL;

public class RepeatedStringMatch {
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            int count = 0;
            StringBuilder b = new StringBuilder();
            while ( b.length() < B.length()) {
                b.append(A);
                count++;
            }

            String re = b.toString();
            if ( re.contains(B)) return count;
            if ( b.append(A).toString().contains(B)) return count + 1;
            return -1;
        }
    }
}
