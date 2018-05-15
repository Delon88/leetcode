package LC.SOL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {
    class Vector2D implements Iterator<Integer> {

        Iterator<List<Integer>> outer;
        Iterator<Integer> inner;
        public Vector2D(List<List<Integer>> vec2d) {
            outer = vec2d.iterator();
            inner = new ArrayList<Integer>().iterator();
        }

        @Override
        public Integer next() {
            if ( hasNext()) {
                return inner.next();
            }
            return -1;
        }

        @Override
        public boolean hasNext() {
            // find next inner has element
            while ( !inner.hasNext() && outer.hasNext()) {
                inner = outer.next().iterator();
            }
            return inner.hasNext();
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
