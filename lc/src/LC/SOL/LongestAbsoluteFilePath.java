package LC.SOL;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public class Solution {
        public int lengthLongestPath(String input) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0); // "dummy" length
            int maxLen = 0;
            for(String s: input.split("\n")) {
                int numOfTabs = s.lastIndexOf("\t") + 1;
                int level = numOfTabs + 1;
                while ( level < stack.size() ) stack.pop();
                int curLen = stack.peek() + s.length() - numOfTabs + 1;
                if ( s.indexOf('.') != -1) maxLen = Math.max(maxLen , curLen);
            }
            return maxLen;
        }
    }
}
