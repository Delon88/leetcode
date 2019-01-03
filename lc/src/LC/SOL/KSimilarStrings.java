package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarStrings {
    class Solution {
        public int kSimilarity(String A, String B) {
            if (A.equals(B)) return 0;
            Queue<String> q = new LinkedList<>();
            Set<String> v = new HashSet<>();
            q.offer(A);
            v.add(A);
            int step = 0;
            while (!q.isEmpty()) {
                step++;
                for (int size = q.size(); size > 0; size--) {
                    String node = q.poll();
                    int i = 0;
                    while (node.charAt(i) == B.charAt(i)) i++;
                    for (int j = i + 1; j < node.length(); j++) {
                        if (node.charAt(j) == B.charAt(j) || node.charAt(i) != B.charAt(j)) continue;
                        String next = swap(node, i, j);
                        if (next.equals(B)) return step;
                        if (v.add(next)) {
                            q.offer(next);
                        }
                    }
                }
            }
            return -1;
        }

        String swap(String A, int i, int j) {
            char[] arr = A.toCharArray();
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            return new String(arr);
        }
    }
}
