package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    class Solution {
        public List<String> removeComments(String[] source) {
            String startStr = "";
            boolean start = false;
            List<String> ret = new ArrayList<>();
            for (String s : source) {
                if (s.contains("//")) {
                    String removed = s.substring(0, s.indexOf("//"));
                    ret.add(removed);
                } else if (s.contains("/*") || s.contains("*/")) {
                    if (s.contains("/*") && !start) {
                        start = true;
                        startStr = s.substring(0, s.indexOf("/*"));
                        s = s.substring(s.indexOf("/*") + 2);
                    }
                    if (s.contains("*/")) {
                        String mulline = startStr + s.substring(s.indexOf("*/") + 2);
                        if (!mulline.equals("")) ret.add(startStr + s.substring(s.indexOf("*/") + 2));
                        start = false;
                    }
                } else {
                    if (!start) {
                        ret.add(s);
                    }
                }
            }
            return ret;
        }
    }
}
