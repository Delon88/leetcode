package LC.SOL;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            if ( path == null || path.length() == 0) return "/";
            String[] ps = path.split("/");
            LinkedList<String> list = new LinkedList<>();
            for ( String p : ps) {
                if ( p.equals(".") || p.equals("")) continue;
                else if ( p.equals("..")) {if (!list.isEmpty()) list.pollLast();}
                else list.add(p);
            }
            if ( list.isEmpty()) {
                return "/";
            } else {
                StringBuilder b = new StringBuilder();
                for ( String p : list) {
                    b.append("/").append(p);
                }
                return b.toString();
            }
        }
    }
}
