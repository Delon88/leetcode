package LC.SOL;

import LC.DS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class FlattenNestedListIterator {
    class NestedIterator implements Iterator<Integer> {

        Stack<Iterator<NestedInteger>> stack;

        Integer next;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(nestedList.iterator());
            next();
        }

        @Override
        public Integer next() {
            Integer ret = next;
            while ( !stack.isEmpty()) {
                if ( !stack.peek().hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger n = stack.peek().next();
                    if ( n.isInteger()) {
                        next = n.getInteger();
                        break;
                    } else {
                        stack.push(n.getList().iterator());
                    }
                }
            }
            if ( stack.isEmpty()) next = null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
