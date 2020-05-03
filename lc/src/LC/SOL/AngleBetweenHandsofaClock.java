package LC.SOL;

public class AngleBetweenHandsofaClock {

    class Solution {
        public double angleClock(int hour, int minutes) {
            double h = (hour % 12) * 30 + ((double) minutes / 60 * 30);
            double m = minutes * 6;
            double diff = Math.abs(h - m);
            if ( diff > 180 ) return 360 - diff;
            else return diff;
        }
    }

}
