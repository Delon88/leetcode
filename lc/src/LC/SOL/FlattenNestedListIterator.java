package LC.SOL;

import LC.DS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class FlattenNestedListIterator {
    class NestedIterator implements Iterator<Integer> {

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(nestedList.listIterator());
        }

        public Integer next() {
            hasNext();
            return stack.peek().next().getInteger();
        }

        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (!stack.peek().hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger i = stack.peek().next();
                    if (i.isInteger()) {
                        stack.peek().previous();
                        return true;
                    } else {
                        stack.push(i.getList().listIterator());
                    }
                }
            }
            return false;
        }

        private Stack<ListIterator<NestedInteger>> stack;
    }
}
