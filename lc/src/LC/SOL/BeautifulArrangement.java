package LC.SOL;

public class BeautifulArrangement {
    public class Solution {
        int count = 0;

        public int countArrangement(int N) {
            if (N == 0) return 0;
            solve(N, 1, new boolean[N + 1]);
            return count;
        }

        private void solve(int N, int pos, boolean[] used) {
            if (pos > N) {
                count++;
                return;
            }

            for (int i = 1; i <= N; i++) {
                if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    solve(N, pos + 1, used);
                    used[i] = false;
                }
            }
        }
    }
}
