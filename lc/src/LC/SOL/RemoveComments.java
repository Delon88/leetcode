package LC.SOL;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveComments {
    class Solution {

        Pattern p = Pattern.compile("(//.*)|(/\\*(.|\n)*?\\*/)");

        public List<String> removeComments(String[] source) {
            String code = String.join("\n", source);
            Pattern p = Pattern.compile("(//.*)|(/\\*(.|\n)*?\\*/)");
            Matcher m = p.matcher(code);
            String[] arr = m.replaceAll("").split("\n");
            List<String> ret = new ArrayList<>();
            for (String s : arr) {
                if ( !s.equals("")) ret.add(s);
            }
            return ret;
        }
    }
}
