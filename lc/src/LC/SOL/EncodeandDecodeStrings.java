package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder b = new StringBuilder();
            for ( String s : strs) {
                b.append(s.length()).append("#").append(s);
            }
            return b.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> words = new ArrayList<>();
            if ( s.length() == 0) return words;
            int i = 0;
            while ( i < s.length() ) {
                int len = 0 ;
                while ( s.charAt(i) != '#') {
                    len = len * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i++;
                if ( len != 0 ) {words.add(s.substring(i, i + len));}
                else {words.add("");}
                i+= len;
            }
            return words;
        }


//        // Encodes a list of strings to a single string.
//        public String encode(List<String> strs) {
//            StringBuilder b = new StringBuilder();
//            for ( String s : strs) {
//                b.append(s.length()).append("#").append(s);
//            }
//            return b.toString();
//        }
//
//        // Decodes a single string to a list of strings.
//        public List<String> decode(String s) {
//            List<String> words = new ArrayList<>();
//            if ( s.length() == 0) return words;
//            int i = 0;
//            while ( i < s.length() ) {
//                int len = 0 ;
//                while ( s.charAt(i) != '#') {
//                    len = len * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                i++;
//                if ( len != 0 ) {words.add(s.substring(i, i + len));}
//                else {words.add("");}
//                i+= len;
//            }
//            return words;
//        }
    }
}
