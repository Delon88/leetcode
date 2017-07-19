package LC.SOL;

import LC.DS.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            ListNode cur = l1 ;
            while ( cur != null ) {
                s1.push(cur.val);
                cur = cur.next;
            }
            cur = l2 ;
            while ( cur != null )  {
                s2.push(cur.val);
                cur = cur.next;
            }
            int carry = 0 ;
            ListNode ret = new ListNode(0);
            while ( !s1.isEmpty() || !s2.isEmpty()) {
                int sum = 0;
                sum += carry;
                if ( !s1.isEmpty()) sum+= s1.pop();
                if ( !s2.isEmpty()) sum+= s2.pop();
                ListNode node = new ListNode( sum % 10) ;
                node.next = ret.next;
                ret.next = node;
                carry = sum / 10 ;
            }
            if ( carry != 0 ) {
                ListNode node = new ListNode(carry);
                node.next = ret.next;
                ret.next = node;
            }
            return ret.next;
        }
    }
}
