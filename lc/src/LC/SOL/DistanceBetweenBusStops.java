package LC.SOL;

public class DistanceBetweenBusStops {
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int i = start, forward = 0;
            while ( i != destination) {
                forward += distance[i]; i++;
                if ( i == distance.length ) i = 0;
            }
            int backward = 0; i = start;
            while ( i != destination) {
                i--; if ( i < 0 ) i = distance.length - 1;
                backward += distance[i];
            }
            return Math.min(forward,backward);
        }
    }
}
