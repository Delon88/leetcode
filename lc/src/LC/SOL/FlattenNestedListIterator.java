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

    class SolutionStack {
        class NestedIterator implements Iterator<Integer> {
            Stack<NestedInteger> stack = new Stack<>();

            public NestedIterator(List<NestedInteger> nestedList) {
                for (int i = nestedList.size() - 1; i >= 0; i--) {
                    stack.push(nestedList.get(i));
                }
            }

            @Override
            public Integer next() {
                hasNext();
                return stack.pop().getInteger();
            }

            @Override
            public boolean hasNext() {
                while (!stack.isEmpty()) {
                    NestedInteger curr = stack.peek();
                    if (curr.isInteger()) {
                        return true;
                    }
                    stack.pop();
                    for (int i = curr.getList().size() - 1; i >= 0; i--) {
                        stack.push(curr.getList().get(i));
                    }
                }
                return false;
            }
        }
    }
}
