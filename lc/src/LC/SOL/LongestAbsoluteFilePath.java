package LC.SOL;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by nanhong on 12/12/2016.
 */
public class LongestAbsoluteFilePath {
    public class Solution {
        public int lengthLongestPath(String input) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0); // "dummy" length
            int maxLen = 0;
            for(String s:input.split("\n")){
                int lev = s.lastIndexOf("\t")+1; // number of "\t"
                while(lev+1<stack.size()) stack.pop(); // find parent
                int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
                stack.push(len);
                // check if it is file
                if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
            }
            return maxLen;
        }
    }
}
