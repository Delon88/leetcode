package LC.SOL;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaxStack {

//    Design a max stack that supports push, pop, top, peekMax and popMax.
//
//            push(x) -- Push element x onto stack.
//            pop() -- Remove the element on top of the stack and return it.
//            top() -- Get the element on the top.
//            peekMax() -- Retrieve the maximum element in the stack.
//            popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
//
//    Example 1:
//
//    MaxStack stack = new MaxStack();
//             stack.push(5);
//             stack.push(1);
//             stack.push(5);
//             stack.top(); -> 5
//             stack.popMax(); -> 5
//             stack.top(); -> 1
//             stack.peekMax(); -> 5
//             stack.pop(); -> 1
//             stack.top(); -> 5


    class DoubleLinkedListNode {
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        Set<String> keys;
        int val;

        public DoubleLinkedListNode(int val) {
            this.val = val;
            this.keys = new HashSet<>();
        }
    }
    /**
     * initialize your data structure here.
     */
    DoubleLinkedListNode head;

    Stack<DoubleLinkedListNode> stack;

    public MaxStack() {
        head = new DoubleLinkedListNode(0);
        head.next = head;
        head.prev = head;
        stack = new Stack<>();
    }

    public void push(int x) {

    }

    public int pop() {

    }

    public int top() {

    }

    public int peekMax() {

    }

    public int popMax() {

    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
}
