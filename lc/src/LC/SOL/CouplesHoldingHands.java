package LC.SOL;


public class CouplesHoldingHands {
    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int[][] couples = new int[n / 2][2];
            for (int i = 0; i < row.length; i++) {
                couples[row[i] / 2][row[i] % 2 == 0 ? 0 : 1] = i / 2;
            }

            int[] v = new int[n / 2];
            int ret = 0;
            for (int i = 0; i < n / 2; i++) {
                if (couples[i][0] == couples[i][1] || v[couples[i][0]] == 2) continue;
                else {
                    int[] count = {0};
                    dfs(0, i, v , couples, row, count);
                    ret += count[0] - 1;
                }
            }
            return ret;
        }

        void dfs(int whichCouple, int ithCouple, int[] v, int[][] couples, int[] row, int[] count) {
            v[couples[ithCouple][whichCouple]] = 1;
            for (int i = 0; i <= 1; i++) {
                int nextCoupleNum = row[2 * couples[ithCouple][whichCouple ^ 1] + i];
                if (nextCoupleNum / 2 != ithCouple) {
                    int nextWhichCouple = nextCoupleNum % 2 == 0 ? 0 : 1;
                    int nextIthCouple = nextCoupleNum / 2;
                    if (v[couples[nextIthCouple][nextWhichCouple]] == 0) {
                        dfs(nextWhichCouple, nextIthCouple, v, couples, row, count);
                    }
                }
            }
            v[couples[ithCouple][whichCouple]] = 2;
            count[0]++;
        }
    }
}
