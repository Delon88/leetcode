package LC.SOL;

import LC.DS.TreeNode;

import java.util.Scanner;

public class SerializeandDeserializeBinaryTree {
    class Codec {

        String delimitter = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder b = new StringBuilder();
            ser(root, b);
            return b.toString();
        }

        void ser(TreeNode root, StringBuilder b) {
            if (root == null) {
                b.append("#").append(delimitter);
                return;
            }
            b.append(root.val).append(delimitter);
            ser(root.left, b);
            ser(root.right, b);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Scanner sc = new Scanner(data);
            sc.useDelimiter(delimitter);
            return des(sc);
        }

        TreeNode des(Scanner sc) {
            if (sc.hasNext()) {
                String next = sc.next();
                if (next.equals("#")) return null;
                TreeNode root = new TreeNode(Integer.parseInt(next));
                root.left = des(sc);
                root.right = des(sc);
                return root;
            }
            return null;
        }
    }
}
