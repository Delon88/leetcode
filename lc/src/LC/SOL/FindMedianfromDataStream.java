package LC.SOL;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    class MedianFinder {

        PriorityQueue<Integer> minQ;
        PriorityQueue<Integer> maxQ;

        /** initialize your data structure here. */
        public MedianFinder() {
            minQ = new PriorityQueue<>();
            maxQ = new PriorityQueue<>((a , b) -> b -a );
        }

        public void addNum(int num) {
            maxQ.add(num);
            minQ.add(maxQ.poll());
            if ( maxQ.size() < minQ.size()) {
                maxQ.add(minQ.poll());
            }
        }

        public double findMedian() {
            if ( minQ.size() != maxQ.size() ) return maxQ.peek();
            else return (minQ.peek() + maxQ.peek()) / 2.0d;
        }
    }

}
