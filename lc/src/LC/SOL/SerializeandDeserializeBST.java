package LC.SOL;

import LC.DS.TreeNode;

import java.util.StringTokenizer;

public class SerializeandDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder b = new StringBuilder();
            ser(root, b);
            return b.toString();
        }

        public void ser(TreeNode node, StringBuilder b) {
            if (node == null) b.append('#').append(" ");
            else {
                b.append(node.val).append(' ');
                ser(node.left, b);
                ser(node.right, b);
            }
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            StringTokenizer token = new StringTokenizer(data, " ");
            return des(token);
        }

        public TreeNode des(StringTokenizer token) {
            TreeNode node = null;
            if (token.hasMoreTokens()) {
                String t = token.nextToken();
                if ("#".equals(t)) {
                    return null;
                } else {
                    node = new TreeNode(Integer.parseInt(t));
                    node.left = des(token);
                    node.right = des(token);
                }
            }
            return node;
        }
    }
}
