package LC.SOL;

import java.util.*;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> v = new HashSet<>(Arrays.asList(deadends));
        q.offer("0000");
        int count = 0 ;
        while ( !q.isEmpty()) {
            int size = q.size();
            for ( int i = 0 ; i < size ; i++) {
                String node = q.poll();
                if ( node.equals(target)) return count;
                if ( v.contains(node)) continue;
                // get neighbors
                for ( int j = 0 ; j < 4 ; j++) {
                    char[] nei = node.toCharArray();
                    // +
                    if ( nei[j] == '9') { nei[j] = '0';}
                    else nei[j]++;
                    if ( !v.contains(new String(nei))) q.add(new String(nei));
                    // -
                    nei = node.toCharArray();
                    if ( nei[j] == '0') { nei[j] = '9';}
                    else nei[j]--;
                    if ( !v.contains(new String(nei))) q.add(new String(nei));
                }
                v.add(node);
            }
            count++;
        }
        return -1;
    }
}
