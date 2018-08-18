package LC.SOL;

import LC.DS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class FlattenNestedListIterator {
    class NestedIterator implements Iterator<Integer> {

        Stack<Iterator<NestedInteger>> stack;

        NestedInteger next;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return next != null ? next.getInteger() : null;
        }

        @Override
        public boolean hasNext() {
            while ( !stack.isEmpty()) {
                if ( !stack.peek().hasNext()) stack.pop();
                else if ( (next = stack.peek().next()).isInteger()) return true;
                else { stack.push(next.getList().iterator()) ;}
            }
            return false;
        }
    }
}
