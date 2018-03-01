package LC.SOL;

public class ZumaGame {
    public static class Solution {

        int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

        public int findMinStep(String board, String hand) {
            int[] handCount = new int[26];
            for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
            int rs = helper(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
            return rs == MAXCOUNT ? -1 : rs;
        }

        private int helper(String s, int[] h) {
            s = removeConsecutive(s);
            if (s.equals("#")) return 0;
            int rs = MAXCOUNT, need = 0;

            for (int start = 0, end = 0; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) continue;
                need = 3 - (end - start);
                if ( h[s.charAt(start) - 'A'] >= need) {
                    h[s.charAt(start) - 'A']-= need;
                    rs = Math.min(rs , need + helper(s.substring(0 , start) + s.substring(end) , h ));
                    h[s.charAt(start) - 'A']+= need;
                }
                start = end;
            }

            return rs;
        }

        String removeConsecutive(String board) {
            for (int start = 0, end = 0; end < board.length(); end++) {
                if (board.charAt(start) == board.charAt(end)) {
                    continue;
                }
                if (end - start >= 3) {
                    return removeConsecutive(board.substring(0, start) + board.substring(end));
                } else {
                    start = end;
                }
            }
            return board;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinStep("WWRRBBWW", "WRBRW"));
    }
}
