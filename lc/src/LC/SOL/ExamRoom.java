package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ExamRoom {

    int N;
    PriorityQueue<Interval> pq;
    class Interval {
        int s, e, dist;
        public Interval(int s, int e) {
            this.s = s; this.e = e;
            if ( s == -1 ) { dist = e;}
            else if ( e == N ) { dist = N - s - 1;}
            else { dist = Math.abs ( s - e ) / 2;}
        }
    }
    public ExamRoom(int N) {
        this.N = N;
        this.pq = new PriorityQueue<>((a, b) -> a.dist == b.dist ? a.s - b.s : b.dist - a.dist);
        pq.add(new Interval(-1 , N ));
    }

    public int seat() {
        int seat = 0;
        Interval in = pq.poll();
        if ( in.s == -1 ) seat = 0;
        else if ( in.e == N ) seat =  N - 1;
        else seat = ( in.s + in.e ) / 2;
        pq.offer(new Interval(in.s , seat));
        pq.offer(new Interval(seat, in.e));
        return seat;
    }

    public void leave(int p) {
        Interval head = null, tail = null;
        for ( Interval in : pq ) {
            if ( in.s == p ) tail = in;
            if ( in.e == p) head = in;
            if ( head != null && tail != null) break;
        }
        pq.remove(head);
        pq.remove(tail);
        pq.offer(new Interval(head.s , tail.e));
    }

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
}
