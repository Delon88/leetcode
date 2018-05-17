package LC.SOL;

import java.util.*;

public class RemoveInvalidParentheses {

//    Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
//    Note: The input string may contain letters other than the parentheses ( and ).
//
//    Example 1:
//
//    Input: "()())()"
//    Output: ["()()()", "(())()"]
//    Example 2:
//
//    Input: "(a)())()"
//    Output: ["(a)()()", "(a())()"]
//    Example 3:
//
//    Input: ")("
//    Output: [""]

    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            Queue<String> q = new LinkedList<>();
            List<String> ret = new ArrayList<>();
            q.offer(s);
            boolean found = false;
            Set<String> v = new HashSet<>();
            v.add(s);
            while ( !q.isEmpty()) {
                String cand = q.poll();
                if ( isValid(cand)) {
                    ret.add(cand);
                    found = true;
                }
                if ( found) continue;
                for( int i = 0 ;i < cand.length() ; i++) {
                    if ( cand.charAt(i) == '(' || cand.charAt(i) == ')') {
                        String next = cand.substring(0 , i ) + cand.substring(i + 1);
                        if ( !v.contains(next)) {
                            q.offer(next);
                            v.add(next);
                        }
                    }
                }
            }
            return ret;
        }

        boolean isValid(String s) {
            int left = 0, right = 0 ;
            for ( int i = 0 ; i < s.length()  ;i++) {
                if ( s.charAt(i) == '(') left++;
                else if ( s.charAt(i) == ')') right++;
                if ( right > left ) return false;
            }
            return left == right;
        }

    }
}
