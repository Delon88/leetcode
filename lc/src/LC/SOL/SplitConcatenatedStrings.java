package LC.SOL;


import java.util.Arrays;

public class SplitConcatenatedStrings {
    class Solution {
        public String splitLoopedString(String[] strs) {

            for (int i = 0; i < strs.length; i++) {
                String rev = new StringBuffer(strs[i]).reverse().toString();
                if (strs[i].compareTo(rev) < 0) {
                    strs[i] = rev;
                }
            }

            String ret = "";
            for (int i = 0; i < strs.length; i++) {
                String rev = new StringBuilder(strs[i]).reverse().toString();
                for (String st : new String[]{strs[i], rev}) {
                    for (int k = 0; k < st.length(); k++) {
                        StringBuilder t = new StringBuilder(st.substring(k));
                        for (int j = i + 1; j < strs.length; j++) {
                            t.append(strs[j]);
                        }
                        for (int j = 0; j < i; j++) {
                            t.append(strs[j]);
                        }
                        t.append(st.substring(0, k));
                        if (t.toString().compareTo(ret) > 0) {
                            ret = t.toString();
                        }
                    }
                }
            }
            return ret.toString();
        }
    }
}
