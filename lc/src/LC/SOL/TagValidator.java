package LC.SOL;

import java.util.Stack;

public class TagValidator {
    class Solution {
        public boolean isValid(String code) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < code.length(); ) {
                if (i > 0 && stack.isEmpty()) return false;
                if (code.startsWith("<![CDATA[", i)) {
                    int j = i + 9;
                    i = code.indexOf("]]>", j);
                    if (i < 0) return false;
                    i += 3;
                } else if (code.startsWith("</", i)) {
                    if (stack.isEmpty()) return false;
                    int j = i + 2;
                    i = code.indexOf(">", j);
                    if (i < 0 || j == i || i - j > 9) return false;
                    for (int k = j; k < i; k++) {
                        if (!Character.isUpperCase(code.charAt(k))) return false;
                    }
                    String tag = code.substring(j, i);
                    if (!tag.equals(stack.pop())) return false;
                    i++;
                } else if (code.startsWith("<", i)) {
                    int j = i + 1;
                    i = code.indexOf(">", j);
                    if (i < 0 || j == i || i - j > 9) return false;
                    for (int k = j; k < i; k++) {
                        if (!Character.isUpperCase(code.charAt(k))) return false;
                    }
                    String tag = code.substring(j, i);
                    stack.push(tag);
                    i++;
                } else {
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }
}
