package LC.SOL;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.*;

public class AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            // compare two words
            Map<Character, Set<Character>> graph = new HashMap<>();
            for ( String w : words) {
                for ( char c : w.toCharArray()) {
                    graph.putIfAbsent(c , new HashSet<>());
                }
            }
            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i];
                String w2 = words[i + 1];
                for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        graph.get(c1).add(c2);
                        break;
                    }
                }
            }
            LinkedList<Character> list = new LinkedList<>();
            Map<Character, Integer> v = new HashMap<>();
            for (Character node : graph.keySet()) {
                if (!v.containsKey(node)) {
                    if (!dfs(graph, v, node, list)) return "";
                }
            }
            StringBuilder b = new StringBuilder();
            for (Character c : list) {
                b.append(c);
            }
            return b.toString();
        }

        boolean dfs(Map<Character, Set<Character>> graph, Map<Character, Integer> v, char node, LinkedList<Character> list) {
            if (v.containsKey(node)) {
                if (v.get(node) == 1) return false;
                if (v.get(node) == 2) return true;
            }
            v.put(node, 1);
            for (Character nei : graph.get(node)) {
                if (!dfs(graph, v, nei, list)) return false;
            }
            v.put(node, 2);
            list.addFirst(node);
            return true;
        }
    }

    class Solution1 {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            Map<Character, Integer> degree = new HashMap<>();
            for (String s : words) {
                for (char c : s.toCharArray()) {
                    if (!graph.containsKey(c)) {
                        graph.put(c, new HashSet<>());
                        degree.put(c, 0);
                    }
                }
            }
            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i];
                String w2 = words[i + 1];
                for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        if (!graph.get(c1).contains(c2)) degree.put(c2, degree.get(c2) + 1);
                        graph.get(c1).add(c2);
                        break;
                    }
                }
            }

            Queue<Character> q = new LinkedList<>();
            for (Map.Entry<Character, Integer> e : degree.entrySet()) {
                if (e.getValue() == 0) q.add(e.getKey());
            }
            String ret = "";
            while (!q.isEmpty()) {
                char c = q.poll();
                ret += c;
                for (char nei : graph.get(c)) {
                    degree.put(nei, degree.get(nei) - 1);
                    if (degree.get(nei) == 0) q.add(nei);
                }
            }
            if (ret.length() != degree.size()) return "";
            return ret;
        }
    }
}
