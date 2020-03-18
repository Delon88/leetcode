package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SerializeandDeserializeBST {
    public class Codec {
        String d = ",";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder b = new StringBuilder();
            ser(b , root);
            return b.toString();
        }

        void ser(StringBuilder b, TreeNode root) {
            if ( root == null ) return;
            b.append(root.val).append(d);
            ser(b, root.left);
            ser(b, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ( data.length() == 0) return null;
            String[] arr = data.split(d);
            Queue<Integer> q = new LinkedList<>();
            for ( String s : arr ) q.add(Integer.parseInt(s));
            return des(q);
        }

        TreeNode des(Queue<Integer> q) {
            if (q.isEmpty()) return null;
            int rValue = q.poll();
            Queue<Integer> less = new LinkedList<>();
            Queue<Integer> greater = new LinkedList<>();
            while ( !q.isEmpty()) {
                int v = q.poll();
                if ( v < rValue ) less.offer(v); else greater.offer(v);
            }
            TreeNode root =new TreeNode(rValue);
            root.left = des(less); root.right = des(greater);
            return root;
        }
    }
}
