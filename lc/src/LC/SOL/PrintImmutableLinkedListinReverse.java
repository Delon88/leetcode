package LC.SOL;

public class PrintImmutableLinkedListinReverse {
    class Solution {
        public void printLinkedListInReverse(ImmutableListNode head) {
            if (head != null) {
                printLinkedListInReverse(head.getNext());
                head.printValue();
            }
        }
    }


    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }
}
