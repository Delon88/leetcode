package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizebyCommonFactor {
    class Solution {

        public int largestComponentSize(int[] A) {
            int N = A.length;
            Map<Integer, Integer> map = new HashMap<>();
            UF uf = new UF(N);
            for (int i = 0; i < N; i++) {
                int a = A[i];
                for (int j = 2; j * j <= a; j++) {
                    if (a % j == 0) {
                        if (!map.containsKey(j)) {
                            map.put(j, i);
                        } else {
                            uf.union(i, map.get(j));
                        }
                        if (!map.containsKey(a / j)) {
                            map.put(a / j, i);
                        } else {
                            uf.union(i, map.get(a / j));
                        }
                    }
                }
                if (!map.containsKey(a)) {
                    map.put(a, i);
                } else {
                    uf.union(i, map.get(a));
                }
            }
            return uf.max;
        }

        class UF {
            int max;
            int[] pa;
            int[] size;

            public UF(int N) {
                pa = new int[N];
                size = new int[N];
                max = 1;
                for (int i = 0; i < N; i++) {
                    pa[i] = i;
                    size[i] = 1;
                }
            }

            int find(int i) {
                while (i != pa[i]) {
                    pa[i] = pa[pa[i]];
                    i = pa[i];
                }
                return i;
            }

            void union(int i, int j) {
                int ri = find(i);
                int rj = find(j);
                if (ri != rj) {
                    pa[ri] = rj;
                    size[rj] += size[ri];
                    max = Math.max(size[rj], max);
                }
            }
        }
    }
}
