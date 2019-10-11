package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    class FileSystem {

        Map<String, Integer> files;

        public FileSystem() {
            files = new HashMap<>();
            files.put("", -1);
        }

        public boolean createPath(String path, int value) {
            int i = path.lastIndexOf("/");
            String parent = path.substring(0 , i);
            if ( !files.containsKey(parent)) return false;
            return files.putIfAbsent(path, value) == null;
        }

        public int get(String path) {
            return files.getOrDefault(path, - 1);
        }
    }
}
