package LC.SOL;

import java.util.*;

public class DesignInMemoryFileSystem {
    static class FileSystem {

        //        ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
//                [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
        class File {
            boolean isFile = false;
            String baseName = "";
            Map<String, File> ch = new HashMap<>();
            StringBuilder content = new StringBuilder();
        }

        File root = null;

        public FileSystem() {
            root = new File();
            root.baseName = "/";
        }

        public List<String> ls(String path) {
            List<String> ret = new ArrayList<>();
            String[] paths = path.split("/");
            File cur = root;
            for (String p : paths) {
                if ( p.length() == 0 ) continue;
                if (!cur.ch.containsKey(p)) {
                    return ret;
                } else {
                    cur = cur.ch.get(p);
                }
            }
            if (cur.isFile) {
                ret.add(cur.baseName);
            } else {
                for (String fileName : cur.ch.keySet()) {
                    ret.add(fileName);
                }
            }
            Collections.sort(ret);
            return ret;
        }


        public void mkdir(String path) {
            File cur = root;
            for (String p : path.split("/")) {
                if ( p.length() == 0 ) continue;
                if (!cur.ch.containsKey(p)) {
                    File file = new File();
                    file.baseName = p;
                    cur.ch.put(p, file);
                }
                cur = cur.ch.get(p);
            }
        }

        public void addContentToFile(String filePath, String content) {
            File cur = root;
            String[] paths = filePath.split("/");
            for (int i = 0; i < paths.length; i++) {
                if ( paths[i].length() == 0 ) continue;
                if (i != paths.length - 1) {
                    if (!cur.ch.containsKey(paths[i])) {
                        return;
                    } else {
                        cur = cur.ch.get(paths[i]);
                    }
                } else {
                    if (cur.ch.containsKey(paths[i])) {
                        if ( !cur.ch.get(paths[i]).isFile) return;
                    } else {
                        File file = new File();
                        file.baseName = paths[i];
                        file.isFile = true;
                        cur.ch.put(paths[i], file);
                    }
                    cur = cur.ch.get(paths[i]);
                }
            }
            cur.content.append(content);
        }

        public String readContentFromFile(String filePath) {
            File cur = root;
            for (String p : filePath.split("/")) {
                if ( p.length() == 0 ) continue;
                if (!cur.ch.containsKey(p)) {
                    return "";
                }
                cur = cur.ch.get(p);
            }
            return cur.content.toString();
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
}

