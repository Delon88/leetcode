package LC.SOL;

import java.util.*;

public class NumberofDistinctIslandsII {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] trans = {{1, 1} , {1 , -1}, {-1, 1}, { -1, -1}};

        public int numDistinctIslands2(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            boolean[][] v = new boolean[m][n];
            Set<String> formSet = new HashSet<>();
            for ( int i = 0 ;i < m ; i++) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( grid[i][j] == 1 && !v[i][j]) {
                        List<int[]> list = new ArrayList<>();
                        dfs(grid, v , i , j , list);
                        formSet.add(getFirstForm(list));
                    }

                }
            }
            return formSet.size();
        }

        void dfs(int[][] grid, boolean[][] v, int x, int y, List<int[]> list) {
            if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || v[x][y] || grid[x][y] == 0 ) return;
            list.add(new int[]{x, y});
            v[x][y] = true;
            for ( int[] d : dirs) {
                int nextX = x + d[0]; int nextY = y + d[1];
                dfs(grid, v, nextX, nextY, list);
            }
        }

        String getFirstForm(List<int[]> list) {

            // (x,y) (x, -y) ( -x,y) ( -x,-y)
            // (y,x) (y, -x) (-y, x) (
            List<String> forms = new ArrayList<>();
            for ( int[] t : trans) {
                List<int[]> f1 = new ArrayList<>();
                List<int[]> f2 = new ArrayList<>();
                for ( int[] c : list) {
                    f1.add(new int[]{c[0] * t[0], c[1] * t[1]});
                    f2.add(new int[]{c[1] * t[1] , c[0] * t[0]});
                }
                forms.add(getFormKey(f1));
                forms.add(getFormKey(f2));
            }
            Collections.sort(forms);
            return forms.get(0);
        }

        String getFormKey(List<int[]> f) {
            Collections.sort(f, (a , b ) -> { if (a[0] != b[0]) return a[0] - b[0]; else return a[1] - b[1];});

            int oX = f.get(0)[0], oY = f.get(0)[1];
            StringBuilder b = new StringBuilder();
            for ( int[] e : f) {
                b.append(e[0] - oX).append(":").append(e[1] - oY).append(",");
            }
            return b.toString();
        }
    }
}
