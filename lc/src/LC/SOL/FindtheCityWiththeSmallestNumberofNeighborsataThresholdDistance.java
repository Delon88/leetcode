package LC.SOL;

import java.util.Arrays;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] dist = new int[n][n];
            int res = 0, smallest = n;
            for (int[] r : dist) {
                Arrays.fill(r, 10001);
            }
            for (int[] e : edges) {
                dist[e[0]][e[1]] = dist[e[1]][e[0]] = e[2];
            }
            for (int i = 0; i < n; i++)
                dist[i][i] = 0;
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] <= distanceThreshold) {
                        count++;
                    }
                }
                if (count <= smallest) {
                    res = i;
                    smallest = count;
                }
            }
            return res;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int res = 0, min = n;
        for ( int[] d : dist) Arrays.fill(d, 10001);
        for ( int[] e : edges) dist[e[0]][e[1]] = dist[e[1]][e[0]] = e[2];
        for ( int i = 0 ; i < n ; i++) dist[i][i] = 0;
        for ( int k = 0 ; k < n ; k++) {
            for ( int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if ( dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        for ( int i = 0 ; i < n ; i++) {
            int count = 0;
            for ( int j = 0 ; j < n ; j++) {
                if ( dist[i][j] <= distanceThreshold) count++;
            }
            if ( count <= min ) {
                res = i;
                min = count;
            }
        }
        return res;
    }
}
