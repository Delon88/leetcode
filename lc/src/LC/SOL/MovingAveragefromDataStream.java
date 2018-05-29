package LC.SOL;

import java.util.LinkedList;

public class MovingAveragefromDataStream {
    class MovingAverage {

        int size;
        LinkedList<Integer> list;
        long sum;
        double avg;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            list = new LinkedList<>();
            avg = 0;
        }

        public double next(int val) {
            if ( list.size() == size ) {
                sum -= list.removeFirst();
            }
            list.add(val);
            sum += val;
            avg = (double) sum / list.size();
            return avg;
        }
    }

}
