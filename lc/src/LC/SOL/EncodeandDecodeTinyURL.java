package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL {
    public class Codec {

        Map<String, String> forward = new HashMap<>();
        Map<String, String> backward = new HashMap<>();
        static String BASE_HOST = "http://tinyurl.com/";
        char[] base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (forward.containsKey(longUrl)) {
                return BASE_HOST + forward.get(longUrl);
            }
            String key = null;
            do {
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    b.append(base[(int) (Math.random() * base.length)]);
                }
                key = b.toString();
            } while (backward.containsKey(key));
            forward.put(longUrl, key);
            backward.put(key, longUrl);
            return BASE_HOST + key;
        }
        // Decodes a shortened URL to its original URL.

        public String decode(String shortUrl) {
            return backward.get(shortUrl.replace(BASE_HOST, ""));
        }
    }

}
