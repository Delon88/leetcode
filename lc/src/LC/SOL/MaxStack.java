package LC.SOL;

import java.util.*;

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

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        stack.top();
        stack.popMax();
        stack.top();
        stack.peekMax();
        stack.print();
        System.out.println(stack.pop());
        stack.top();
    }
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

    public void print() {
        DoubleLinkedListNode cur = head.next;
        while ( cur != head) {
            System.out.print(cur.val + ",");
            cur =cur.next;
        }
    }
    public MaxStack() {
        head = new DoubleLinkedListNode(0);
        head.next = head;
        head.prev = head;
        stack = new Stack<>();
    }

    public DoubleLinkedListNode addTail(int val) {
        DoubleLinkedListNode tail = head.prev;
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(val);
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public int remove(DoubleLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        return node.val;
    }


    public void push(int x) {
        DoubleLinkedListNode newNode = addTail(x);
        if (stack.isEmpty() || x >= stack.peek().val) {
            stack.push(newNode);
        }
    }

    public int pop() {
        int value = remove(head.prev);
        if (!stack.isEmpty() && stack.peek().val == value) {
            stack.pop();
        }
        return value;
    }

    public int top() {
        return head.prev.val;
    }

    public int peekMax() {
        if (!stack.isEmpty()) {
            return stack.peek().val;
        }
        return -1;
    }

    public int popMax() {
        if (!stack.isEmpty()) {
            DoubleLinkedListNode node = stack.peek();
            Stack<Integer> tmp = new Stack<>();
            int v = 0;
            while ((v = pop()) != node.val) {
                tmp.push(v);
            }
            while (!tmp.isEmpty()) {
                push(tmp.pop());
            }
            return node.val;
        } else {
            return -1;
        }
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
