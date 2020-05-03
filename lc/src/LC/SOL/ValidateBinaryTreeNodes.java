package LC.SOL;

import java.math.BigInteger;

public class ValidateBinaryTreeNodes {
    class Solution {
        int[] id;

        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            BigInteger b1 = new BigInteger("");
            b1.add(new BigInteger("2"));
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            for (int i = 0; i < n; i++) {
                int l = leftChild[i];
                int r = rightChild[i];
                int root = find(i);
                int ra = find(l);
                int rb = find(r);
                // if any of the child belongs to an existing root(not itself or -1)
                if (ra != l || rb != r) return false;
                if (ra == rb && ra != -1) return false;

                if ((root == ra && ra != -1) || (root == rb && rb != -1)) return false;
                if (l != -1) id[ra] = root;
                if (r != -1) id[rb] = root;
            }
            // all should belong the same root
            int root = find(0);
            for (int i = 1; i < n; i++) {
                int r = find(i);
                if (r != root) return false;
            }
            return true;


        }

        private int find(int i) {
            if (i == -1) return -1;
            while (id[i] != i) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }

}
