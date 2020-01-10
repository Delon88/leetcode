package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder b = new StringBuilder();
            for (String s : strs) {
                b.append(s.length()).append("#").append(s);
            }
            return b.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> words = new ArrayList<>();
            if (s.length() == 0) return words;
            int i = 0;
            while (i < s.length()) {
                int d = s.indexOf("#", i);
                int len = Integer.parseInt(s.substring(i , d));
                i = d + 1 + len;
                words.add(s.substring(d + 1, i));
            }
            return words;
        }
    }

    public class Codec2 {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder b = new StringBuilder();
            for (String s : strs) {
                b.append(s.replaceAll("#", "##")).append(" # ");
            }
            return b.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            String[] words = s.split(" # ", -1);
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < words.length - 1; i++) {
                ret.add(words[i].replaceAll("##", "#"));
            }
            return ret;
        }
    }
}
